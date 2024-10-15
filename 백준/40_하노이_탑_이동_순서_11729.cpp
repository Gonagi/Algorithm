// 하노이 탑 이동 순서
// 11729

/*
#include <iostream>

void hanoi(int remainN, int start, int end, int via);
void move(int remainN, int start, int end);

int main()
{
  int N, count = 1;
  std::cin >> N;
  for (int idx = 1; idx <= N; idx++)
    count *= 2;
  count--;

  std::cout << count << '\n';
  hanoi(N, 1, 3, 2);
  return 0;
}

void hanoi(int remainN, int start, int end, int via)
{
  if (remainN == 1)
  {
    move(1, start, end);
    return;
  }
  hanoi(remainN - 1, start, via, end);
  move(remainN, start, end);
  hanoi(remainN - 1, via, end, start);
}

void move(int remainN, int start, int end)
{
  std::cout << start << ' ' << end << '\n';
}
*/