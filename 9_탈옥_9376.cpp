// // 탈옥
// // 9376

// #include <algorithm>
// #include <deque>
// #include <iostream>
// #include <string>
// #include <vector>

// struct Direction
// {
//   int y, x;
// };
// Direction dir[4] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
// Direction prison1, prison2;

// int c, h, w;

// void input(std::vector<std::vector<char>> &map, std::vector<Direction> &door);
// void check(Direction Person, const std::vector<std::vector<char>> &map, std::vector<std::vector<int>> &count);
// bool movable(Direction cur);
// bool is_out(Direction cur);

// int main()
// {
//   std::cin >> c;

//   for (int idx = 0; idx < c; idx++)
//   {
//     std::vector<std::vector<char>> map;
//     std::vector<Direction> door;
//     std::cin >> h >> w;

//     input(map, door);
//     std::vector<std::vector<int>> count(h + 2, std::vector<int>(w + 2, -1));
//     std::vector<std::vector<int>> count1(h + 2, std::vector<int>(w + 2, -1));
//     std::vector<std::vector<int>> count2(h + 2, std::vector<int>(w + 2, -1));

//     check({0, 0}, map, count);
//     check(prison1, map, count1);
//     check(prison2, map, count2);

//     int min = 10001, cal;

//     for (int y = 1; y <= h; y++)
//     {
//       for (int x = 1; x <= w; x++)
//       {
//         if (count[y][x] >= 0 && count1[y][x] >= 0 && count2[y][x] >= 0)
//         {
//           cal = count[y][x] + count1[y][x] + count2[y][x];
//           if (map[y][x] == '#')
//             cal -= 2;

//           min = std::min(min, cal);
//         }
//       }
//     }

//     std::cout << min << '\n';
//   }
//   return 0;
// }

// void input(std::vector<std::vector<char>> &map, std::vector<Direction> &door)
// {
//   std::string str;
//   bool check_prisoner = false;

//   for (int y = 0; y < h; y++)
//   {
//     std::cin >> str;
//     std::vector<char> map_x;

//     if (y == 0)
//       map.push_back(std::vector<char>(w + 2, '.'));

//     for (int x = 0; x < w; x++)
//     {
//       if (x == 0)
//         map_x.push_back('.');

//       map_x.push_back(str[x]);

//       if (str[x] == '#')
//         door.push_back({y + 1, x + 1});
//       else if (str[x] == '$')
//       {
//         if (!check_prisoner)
//         {
//           prison1.y = y + 1;
//           prison1.x = x + 1;
//           check_prisoner = true;
//         }
//         else
//         {
//           prison2.y = y + 1;
//           prison2.x = x + 1;
//         }
//       }
//     }
//     map_x.push_back('.');
//     map.push_back(map_x);
//   }
//   map.push_back(std::vector<char>(w + 2, '.'));
// }

// void check(Direction Person, const std::vector<std::vector<char>> &map, std::vector<std::vector<int>> &count)
// {
//   std::vector<std::vector<bool>> visited(h + 2, std::vector<bool>(w + 2, false));
//   std::deque<Direction> deque;
//   deque.push_back(Person);
//   count[Person.y][Person.x] = 0;

//   while (!deque.empty())
//   {
//     Direction Cur = deque.front();
//     deque.pop_front();

//     for (int d = 0; d < 4; d++)
//     {
//       Direction Next({Cur.y + dir[d].y, Cur.x + dir[d].x});
//       if (movable(Next) && count[Next.y][Next.x] == -1)
//       {
//         if (map[Next.y][Next.x] == '.' || map[Next.y][Next.x] == '$')
//         {
//           deque.push_front(Next);
//           count[Next.y][Next.x] = count[Cur.y][Cur.x];
//         }

//         else if (map[Next.y][Next.x] == '#')
//         {
//           deque.push_back(Next);
//           count[Next.y][Next.x] = count[Cur.y][Cur.x] + 1;
//         }
//       }
//     }
//   }
// }

// bool movable(Direction cur)
// {
//   if (cur.y < 0 || cur.y >= h + 2 || cur.x < 0 || cur.x >= w + 2)
//     return false;
//   return true;
// }

// bool is_out(Direction cur)
// {
//   if (cur.y == 0 || cur.y == h - 1 || cur.x == 0 || cur.x == w - 1)
//     return true;
//   return false;
// }

//
//
//
//
//
//
//
//
//
//
//

// 숨바꼭질 3
// 13549

// #include <deque>
// #include <iostream>

// int N, K;
// int count[100001];

// int main()
// {
//   std::cin >> N >> K;
//   std::fill_n(count, 100001, 100001);

//   std::deque<int> deque;
//   deque.push_front(N);
//   count[N] = 0;

//   while (!deque.empty())
//   {
//     int cur = deque.front();
//     int cur_count = count[cur];
//     deque.pop_front();

//     if (cur == K)
//     {
//       std::cout << cur_count << '\n';
//       return 0;
//     }

//     if (2 * cur <= 100000 && count[2 * cur] > count[cur])
//     {
//       deque.push_front(2 * cur);
//       count[2 * cur] = cur_count;
//     }
//     if (cur + 1 <= 100000 && count[cur + 1] > count[cur] + 1)
//     {
//       deque.push_back(cur + 1);
//       count[cur + 1] = cur_count + 1;
//     }
//     if (cur - 1 >= 0 && count[cur - 1] > count[cur] + 1)
//     {
//       deque.push_back(cur - 1);
//       count[cur - 1] = cur_count + 1;
//     }
//   }

//   return 0;
// }
// */