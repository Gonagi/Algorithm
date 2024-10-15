// 소수&팰린드롬
// 1747

/*
#include <algorithm>
#include <iostream>
#include <string>

bool isPrime(int num);
bool isPalindrome(int num);

int main()
{
  std::ios_base::sync_with_stdio(0);
  std::cin.tie(0);
  std::cout.tie(0);

  int input;
  std::cin >> input;
  for (int num = input;; num++)
  {
    if (isPrime(num) && isPalindrome(num))
    {
      std::cout << num << '\n';
      break;
    }
  }
  return 0;
}

bool isPrime(int num)
{
  if (num == 1)
    return false;
  for (int cur = 2; cur * cur <= num; cur++)
    if (num % cur == 0)
      return false;
  return true;
}

bool isPalindrome(int num)
{
  std::string front, back, str = std::to_string(num);
  front = str;
  std::reverse(str.begin(), str.end());
  back = str;

  if (front == back)
    return true;
  return false;
}
*/