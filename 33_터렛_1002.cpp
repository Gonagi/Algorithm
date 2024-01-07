// 터렛
// 1002

/*
#include <iostream>

int main()
{
  int x1, y1, r1, x2, y2, r2, T;

  std::cin >> T;

  for (int idx = 0; idx < T; idx++)
  {
    std::cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

    if (x1 == x2 && y1 == y2 && r1 == r2)
      std::cout << -1 << '\n';
    else
    {
      int powPlusRadius = (r1 + r2) * (r1 + r2);
      int powMinusRadius = (r1 - r2) * (r1 - r2);
      int powcalDistance =
          (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

      if (powPlusRadius > powcalDistance &&
          powMinusRadius < powcalDistance)
        std::cout << 2 << '\n';
      else if (powPlusRadius == powcalDistance)
        std::cout << 1 << '\n';
      else if (powMinusRadius == powcalDistance)
        std::cout << 1 << '\n';
      else if (powPlusRadius < powcalDistance)
        std::cout << 0 << '\n';
      else if (powMinusRadius > powcalDistance)
        std::cout << 0 << '\n';
      else if (x1 == x2 && y1 == y2 && r1 != r2)
        std::cout << 0 << '\n';
    }
  }
  return 0;
}
*/