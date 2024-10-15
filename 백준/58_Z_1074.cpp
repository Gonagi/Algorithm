// Z
// 1074

/*
#include <iostream>

int N, r, c, result;

void Z(int y, int x, int size);

int main()
{
  std::cin >> N >> r >> c;

  Z(0, 0, (1 << N));

  return 0;
}

void Z(int y, int x, int size)
{
  if (y == r && x == c)
  {
    std::cout << result << '\n';
    return;
  }

  if (r < y + size && r >= y && c < x + size && c >= x)
  {
    Z(y, x, size / 2);
    Z(y, x + size / 2, size / 2);
    Z(y + size / 2, x, size / 2);
    Z(y + size / 2, x + size / 2, size / 2);
  }
  else
  {
    result += size * size;
  }
}
*/