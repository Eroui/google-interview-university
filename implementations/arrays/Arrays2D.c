#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int n, m;
	int *mat, *p, *q;
	
	scanf("%d %d", &n, &m);
	mat = (int *) malloc(n * m * sizeof(int));
	p = mat;
	while(p < (mat + (n*m))) {
		q = p;
		while(q < (p + m)) {
			scanf("%d", q++);
		}
		p += m;
	}
	
	p = mat;
	while(p < mat + (n*m)) {
		q = p;
		while(q < p + m) {
			printf("%d ", *q);
			++q;
		} printf("\n");
		
		p += m;
	}
	
	return 0;
}
