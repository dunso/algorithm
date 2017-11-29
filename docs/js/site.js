/* 页面加载后执行 */
!function ($) {
  $(function(){

    var tableReference;
    /* 初始化dataTable */
    if($('#post-data')[0]){
      tableReference = $('#post-data').dataTable(datatablesConfig);
    }
    /* 初始化tooltip */
    if($('#support a')[0]){
      $('#support a').tooltip(tooltipConfig);
    }

    /* 目录页导航 */
    var url = window.location.href;
    if(url.indexOf('categories.html') > -1){
      $('#categories-nav a').click(function (e){
        $(this).tab('show');
      })

      /* 自动打开链接中的锚点 */
      var matches = url.match(/categories\.html(#.*)/);
      if(matches){
        $('#categories-nav a[href="' + matches[1] + '"]').tab('show');
      }else{
        $('#categories-nav a:first').tab('show');
      }
    } 

    /* 自动根据标签过滤table */
    if(url.indexOf('posts.html') > -1){
      var matches = url.match(/posts\.html#(.*)/);
      if(matches && tableReference){
        tableReference.fnFilter(matches[1],2);
        $('#post-data_filter input').val(matches[1])
      }


      $("#post-data_filter input").keyup( function () {
        tableReference.fnFilter('', 2);
        tableReference.fnFilter( this.value, 2);
      } );
    }
  });

}(window.jQuery);

/* 切换技术支持列表的样式 */
function toggleSupport(){
  $('#support').toggleClass('dispear').toggleClass('show');
  return false;
}

/* datatables设置 */
datatablesConfig = {
  "aaSorting": [[ 0, "desc" ],[ 1, "asc" ],[ 2, "asc" ]],
  "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-6'i><'col-md-6'p>>",
  "sWrapper": "dataTables_wrapper form-inline",
  "sPaginationType": "bootstrap",
  "oLanguage":{
    "sProcessing":   "Processing...",
    "sLengthMenu":   "Show _MENU_ Articles",
    "sZeroRecords":  "No Match Result",
    "sInfo":         "Show _START_ to _END_ Artiles，Total _TOTAL_ Atriles",
    "sInfoEmpty":    "Show 0 to 0 Artiles，Total 0 Atriles",
    "sInfoFiltered": "(Filter By _MAX_ Artiles)",
    "sInfoPostFix":  "",
    "sSearch":       "Search:",
    "sUrl":          "",
    "oPaginate": {
      "sFirst":    "First",
      "sPrevious": "Pre",
      "sNext":     "Next",
      "sLast":     "Last"
    }
  }
}

/* tooltip设置 */
tooltipConfig = {
  "placement": "right",
  "delay": { show: 200, hide: 100 }
}
