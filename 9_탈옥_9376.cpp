#include <iostream>
#include <queue>
#include <string>
#include <vector>

struct Direction
{
  int y, x;
};
Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

int c, h, w;
void input(std::vector<std::vector<char>> &map, std::vector<Direction> &door, std::queue<Direction> &prisoner);

int main()
{
  std::cin >> c;

  for (int idx = 0; idx < c; idx++)
  {
    std::cin >> h >> w;

    std::vector<std::vector<char>> map;
    std::vector<Direction> door;
    std::queue<Direction> prisoner;
    std::vector<std::vector<bool>> visited(h, std::vector<bool>(w, false));

    input(map, door, prisoner);

    int a = 3;
  }
  return 0;
}

void input(std::vector<std::vector<char>> &map, std::vector<Direction> &door, std::queue<Direction> &prisoner)
{
  std::string str;

  for (int y = 0; y < h; y++)
  {
    std::cin >> str;
    std::vector<char> map_x;

    for (int x = 0; x < w; x++)
    {
      map_x.push_back(str[x]);
      if (str[x] == '#')
        door.push_back({y, x});
      else if (str[x] == '$')
        prisoner.push({y, x});
    }
    map.push_back(map_x);
  }
  int a = 3;
}