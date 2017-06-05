using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Csharp.Array
{
    [TestClass]
    public class LeetCode05
    {
        [TestMethod]
        public string Convert(string s, int numRows)
        {
            if (numRows == 1)
            {
                return s;
            }

            var sb = new StringBuilder(s.Length);

            var stepLength = 2 * (numRows - 1);

            var block = (s.Length - 1) / stepLength + 1;

            for (var i = 0; i < numRows; i++)
            {
                for (var j = 0; j <= block; j++)
                {
                    if (i > 0 && i < numRows - 1 && stepLength * j - i > 0 && stepLength * j - i < s.Length)
                    {
                        sb.Append(s[stepLength * j - i]);
                    }
                    if (stepLength * j + i < s.Length)
                    {
                        sb.Append(s[stepLength * j + i]);
                    }
                }
            }
            return sb.ToString();
        }
    }
}