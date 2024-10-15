// DFS와 BFS
// 1260

/*
#include <iostream>
#include <queue>
#include <vector>

int N, M, V;
int node1, node2;
std::vector<std::vector<int>> linkVec(1001,
                                      std::vector<int>(1001, 0));
std::vector<int> visitied(1001, 0);

void DFS(int curNode);
void BFS();

int main()
{

  std::cin >> N >> M >> V;

  for (int idx = 0; idx < M; idx++)
  {
    std::cin >> node1 >> node2;
    linkVec[node1][node2] = 1;
    linkVec[node2][node1] = 1;
  }

  DFS(V);
  std::cout << '\n';
  BFS();
  return 0;
}

void DFS(int curNode)
{
  visitied[curNode] = 1;
  std::cout << curNode << ' ';

  for (int nextNode = 1; nextNode <= N; nextNode++)
  {
    if (linkVec[curNode][nextNode] == 1)
    {
      if (visitied[nextNode])
        continue;
      DFS(nextNode);
    }
  }
}

void BFS()
{
  std::vector<int> Bvisitied(1001, 0);
  std::queue<int> que;
  que.push(V);

  while (!que.empty())
  {
    int curNode = que.front();
    std::cout << curNode << ' ';
    Bvisitied[curNode] = 1;
    que.pop();

    for (int nextNode = 1; nextNode <= N; nextNode++)
    {
      if (linkVec[curNode][nextNode] == 1)
      {
        if (Bvisitied[nextNode])
          continue;
        Bvisitied[nextNode] = 1;
        que.push(nextNode);
      }
    }
  }
  std::cout << '\n';
}
*/