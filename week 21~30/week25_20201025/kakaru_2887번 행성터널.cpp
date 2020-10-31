#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

#define MAX_SIZE 100001

int parent[MAX_SIZE];

int find(int x) {
	if (parent[x] == x)
		return x;
	else
		return parent[x] = find(parent[x]);
}

void unionParent(int x, int y) {
	x = find(x);
	y = find(y);
	parent[y] = x;
}

class Edge {
public:
	int node[2];
	int distance;
	Edge(int x, int y, int distance) {
		this->node[0] = x;
		this->node[1] = y;
		this->distance = distance;
	}
	bool operator<(Edge &edge) {
		return this->distance < edge.distance;
	}
};

class Planet {
public:
	int x, y, z, idx;
	Planet(int x, int y, int z, int idx) {
		this->x = x;
		this->y = y;
		this->z = z;
		this->idx = idx;
	}
};

bool cmpx(Planet a, Planet b) {
	return a.x < b.x;

}
bool cmpy(Planet a, Planet b) {
	return a.y < b.y;
}
bool cmpz(Planet a, Planet b) {
	return a.z < b.z;
}

int main() {
	int N;
	scanf("%d", &N);
	vector<Edge> edge;
	vector<Planet> planet;
	for (int i = 0; i < N; i++) {
		parent[i] = i;
	}
	for (int i = 0; i < N; i++) {
		int x, y, z;
		scanf("%d %d %d", &x, &y, &z);
		planet.push_back(Planet(x, y, z, i));
	}

	sort(planet.begin(), planet.end(), cmpx);
	for (int i = 0; i < N-1; i++) {
		edge.push_back(Edge(planet[i].idx, planet[i+1].idx, abs(planet[i].x - planet[i + 1].x)));
	}
	sort(planet.begin(), planet.end(), cmpy);
	for (int i = 0; i < N - 1; i++) {
		edge.push_back(Edge(planet[i].idx, planet[i + 1].idx, abs(planet[i].y - planet[i + 1].y)));
	}
	sort(planet.begin(), planet.end(), cmpz);
	for (int i = 0; i < N - 1; i++) {
		edge.push_back(Edge(planet[i].idx, planet[i + 1].idx, abs(planet[i].z - planet[i + 1].z)));
	}

	sort(edge.begin(), edge.end());
	int sum = 0;
	int cnt = 0;
	for (int i = 0; i < edge.size(); i++) {
		if (find(edge[i].node[0]) != find(edge[i].node[1])) {
			cnt++;
			sum += edge[i].distance;
			unionParent(edge[i].node[0], edge[i].node[1]);
			if (cnt == N - 1)
				break;
		}			
	}
	printf("%d\n", sum);
	return 0;
}