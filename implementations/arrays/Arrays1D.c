#include <stdio.h>

int main(void) {
	int n;
	int *arr, *p;
	
	scanf("%d", &n);
	arr = (int *) malloc(n * sizeof(int));
	p = arr;
	while(p < arr + n) {
		scanf("%d", p++);
	}
	
	p = arr;
	while(p < arr + n) {
		printf("%d ", *p);
		++p;
	}
	
	return 0;
}
