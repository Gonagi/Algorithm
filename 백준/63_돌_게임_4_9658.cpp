// // 돌 게임 4
// // 9658

/*
#include <iostream>
#include <vector>
#define Max 1000
int main()
{
  int N;
  std::vector<bool> SK_Win;
  SK_Win.resize(Max + 1, true);

  std::cin >> N;
  SK_Win[1] = false;
  SK_Win[2] = true;
  SK_Win[3] = false;
  SK_Win[4] = true;

  for (int turn = 5; turn <= N; turn++)
  {
    if (SK_Win[turn - 1] == true && SK_Win[turn - 3] == true &&
        SK_Win[turn - 4] == true)
      SK_Win[turn] = false;
  }

  if (SK_Win[N])
    std::cout << "SK" << '\n';
  else
    std::cout << "CY" << '\n';

  return 0;
}
*/

// 돌 게임 3
// 9657
/*
#include <iostream>
#include <vector>
#define Max 1000
int main()
{
  int N;
  std::vector<bool> SK_Win;
  SK_Win.resize(Max + 1, true);

  std::cin >> N;
  SK_Win[1] = true;
  SK_Win[2] = false;
  SK_Win[3] = true;
  SK_Win[4] = true;

  for (int turn = 5; turn <= N; turn++)
  {
    if (SK_Win[turn - 1] && SK_Win[turn - 3] && SK_Win[turn - 4])
      SK_Win[turn] = false;
  }

  if (SK_Win[N])
    std::cout << "SK" << '\n';
  else
    std::cout << "CY" << '\n';

  return 0;
}
*/