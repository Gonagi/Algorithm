import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

class UserSolution {
    static class Student implements Comparable<Student> {
        int mId;
        int mScore;

        public Student(int mId, int mScore) {
            this.mId = mId;
            this.mScore = mScore;
        }

        @Override
        public int compareTo(Student o) {
            if (Objects.equals(this.mScore, o.mScore)) {
                return Integer.compare(o.mId, this.mId);
            }
            return Integer.compare(o.mScore, this.mScore);
        }
    }

    static class StudentInfo {
        int mGrade;
        int mGender;
        int mScore;

        public StudentInfo(int mGrade, int mGender, int mScore) {
            this.mGrade = mGrade;
            this.mGender = mGender;
            this.mScore = mScore;
        }
    }

    TreeSet<Student>[][] group;
    Map<Integer, StudentInfo> studentInfo;

    public void init() {
        group = new TreeSet[4][2];
        for (int idx = 1; idx <= 3; idx++) {
            for (int idx2 = 0; idx2 < 2; idx2++) {
                group[idx][idx2] = new TreeSet<>();
            }
        }

        studentInfo = new HashMap<>();
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        int sex = isMale(mGender);
        group[mGrade][sex].add(new Student(mId, mScore));

        studentInfo.put(mId, new StudentInfo(mGrade, sex, mScore));
        Student student = group[mGrade][sex].first();
        return student.mId;
    }

    public int remove(int mId) {
        if (!studentInfo.containsKey(mId)) {
            return 0;
        }
        StudentInfo st = studentInfo.remove(mId);
        group[st.mGrade][st.mGender].remove(new Student(mId, st.mScore));
        studentInfo.remove(mId);

        if (group[st.mGrade][st.mGender].isEmpty()) {
            return 0;
        }
        return group[st.mGrade][st.mGender].last().mId;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        Student result = new Student(0, 300_001);
        Student compare = new Student(0, mScore);
        Student temp;

        for (int idx = 0; idx < mGradeCnt; idx++) {
            int curGrade = mGrade[idx];
            for (int idx2 = 0; idx2 < mGenderCnt; idx2++) {
                int curGender = isMale(mGender[idx2]);
                if (!group[curGrade][curGender].isEmpty()) {
                    temp = group[curGrade][curGender].lower(compare);
                    if (temp != null && result.compareTo(temp) < 0) {
                        result = temp;
                    }
                }
            }
        }
        return result.mId;
    }

    private int isMale(char mGender[]) {
        if (mGender[0] == 'f') {
            return 1;
        }
        return 0;
    }
}

