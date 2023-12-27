// 이번학기 평점은 몇점?
// 2755

// #include <cmath>
// #include <iostream>
// #include <string>
// #include <unordered_map>

// int main()
// {
//   std::string name, score;
//   int subjectNum, grade_sum = 0, grade, sum = 0;
//   std::unordered_map<std::string, int> score_map = {
//       {"A+", 43}, {"A0", 40}, {"A-", 37}, {"B+", 33}, {"B0", 30},
//       {"B-", 27}, {"C+", 23}, {"C0", 20}, {"C-", 17}, {"D+", 13},
//       {"D0", 10}, {"D-", 7},  {"F", 0}};

//   std::cin >> subjectNum;
//   for (int idx = 0; idx < subjectNum; idx++)
//   {
//     std::cin >> name >> grade >> score;
//     sum += score_map[score] * grade;
//     grade_sum += grade;
//   }

//   double average = static_cast<double>(sum) / grade_sum;

//   std::cout << std::round(average * 10) / 10 << '\n';

//   return 0;
// }