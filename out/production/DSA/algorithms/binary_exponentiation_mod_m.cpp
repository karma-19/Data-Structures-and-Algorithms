#include<stdio.h>
#include<conio.h>
#include<iostream>
using namespace std;
typedef long long ll;
long long binpow(ll, ll, ll);
int main(){
	ll ans;
	ll x, n, m;
	printf("enter x,n and m : ");
	cin >> x >> n >> m ;
	ans = binpow(x,n,m);
	
	cout << "the ans is : " << ans << endl;
}

ll binpow(ll a, ll b, ll m){
	a %= m;
	ll res = 1;
	if (a==0) return 0;
	while(b>0){
		if(b&1){
			res = (res * a) %m;
		}
		a = (a* a)%m;
		b>>=1;
		
	}
	return res;
}
