#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<ctype.h>

#define MAX 100
char st[MAX];
int top = -1;
void push(char st[], char);
char pop(char st[]);
int getpriority(char);
void infixTopostfix(char source[], char target[]);
int main(){
	printf("\t************* INFIX TO POSTFIX **************");
	char infix[100], postfix[100];
	printf("\nenter the expression : ");
	gets(infix);
	strcpy(postfix, "");
	infixTopostfix(infix, postfix);
	printf("\nhere is the postfix expression : ");
	puts(postfix);
	
	getch();
	return 0;
	
}

void infixTopostfix(char source[], char target[]){
	int i= 0, j=0;
	char temp;
	while(source[i]!='\0'){
		if(source[i]=='('){
			push(st, source[i]);
			i++;
		}
		else if(source[i]==')'){
			while((st[top]!='(') && (top!=-1)){
				target[j] = pop(st);
				j++;
			}
			if(top==-1){
				printf("-----incorrect expression-------");
				//exit(0);
			}
			temp = pop(st);
			i++;
		}
		else if(isalpha(source[i]) || isdigit(source[i])){
			target[j] = source[i];
			j++;
			i++;
		}
		else if(source[i]=='+' || source[i]=='-' || source[i]=='*' || source[i]=='/' || source[i]=='%'){
			while((getpriority(source[i])< getpriority(st[top])) &&(top!=-1) &&(st[top]=='(')){
				target[j] = pop(st);
				j++;
			}
			push(st, source[i]);
			i++;
		}
		else{
			printf("--------INCORRECT EXPRESSION -----------------");
			//exit(1);
		}
	}
	while((st[top]!='(') && (top!=-1)){
		target[j] = pop(st);
		j++;
	}
	target[j] = '\0';
}

void push(char st[], char val){
	if (top==MAX-1){
		printf("\n----STACK OVERFLOW----");
	}
	else{
		top++;
		st[top] = val;
	}
}

char pop(char st[]){
	char val = ' ';
	if (top==-1){
		printf("\n----STACK UNDERFLOW----");
	}
	else{
		val = st[top];
		top--;
	}
	return val;
}

int getpriority(char op){
	if (op=='/' || op=='*' || op == '%'){
		return 1;
	}
	else if(op=='+' || op=='-'){
		return 0;
	}
	
}
