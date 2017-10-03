#include <stdlib.h>
#include <stdbool.h>

typedef struct _Trie {
	char letter;
	struct _Trie *child;
	struct _Trie *next;
	bool is_leaf;
} Trie;

Trie* trieCreate() {
	Trie *p = (Trie *)malloc(sizeof(Trie));
	p->child = NULL;
	p->next = NULL;
	p->is_leaf = false;
	return p;
}

static void diff(Trie *obj, char *word, Trie **diff_obj, Trie ***child_end, char **diff_word) {
	char *s = word;
	Trie **child = &obj->child;

	if (*s != '\0') {
		for (; *child != NULL; child = &(*child)->next) {
			if (*s == (*child)->letter) {
				diff(*child, ++s, diff_obj, child_end, diff_word);
				return;
			}
		}
	}

	if (diff_obj)
	{
		*diff_obj = obj;
	}
		
	if (child_end)
	{
		*child_end = child;
	}
		
	if (diff_word)
	{
		*diff_word = s;
	}
}

void trieInsert(Trie* obj, char* word) {
	Trie *diff_obj;
	Trie **child_end;
	char *diff_word;

	diff(obj, word, &diff_obj, &child_end, &diff_word);
	char *s = diff_word;
	Trie *leaf = diff_obj;
	while (*s != '\0') 
	{
		*child_end = trieCreate();
		leaf = *child_end;
		leaf->letter = *s++;
		child_end = &leaf->child;
	}
	leaf->is_leaf = true;
}

bool trieSearch(Trie* obj, char* word) {
	Trie *diff_obj;
	char *diff_word;
	diff(obj, word, &diff_obj, NULL, &diff_word);
	return diff_obj->is_leaf && *diff_word == '\0';
}

bool trieStartsWith(Trie* obj, char* prefix) {
	Trie *diff_obj;
	char *diff_word;
	diff(obj, prefix, &diff_obj, NULL, &diff_word);
	return *diff_word == '\0';
}

void trieFree(Trie* obj) {
	if (obj->child == NULL && obj->next == NULL) {
		free(obj);
		return;
	}

	if (obj->child)
	{
		trieFree(obj->child);
	}
		
	if (obj->next)
	{
		trieFree(obj->next);
	}
}
