package samplearrays;

import java.util.Arrays;

public class ManageStudent {

    // 2) oldest student
    public static Student findOldest(Student[] st){
        if (st == null || st.length == 0) return null;
        int bestIdx = 0, bestAge = st[0].getAge();
        for (int k=1; k<st.length; k++){
            if (st[k].getAge() > bestAge){
                bestAge = st[k].getAge();
                bestIdx = k;
            }
        }
        Student oldie = st[bestIdx];
        return oldie;
    }

    // 3) count adults (>=18)
    public static int countAdults(Student[] a){
        if (a == null) return 0;
        int c = 0;
        for (int i=0;i<a.length;i++){
            if (a[i].getAge() >= 18) c++;
        }
        return c;
    }

    // 4) avg grade (NaN if none)
    public static double averageGrade(Student[] bunch){
        if (bunch == null || bunch.length == 0) return Double.NaN;
        double s = 0.0; int n = 0;
        for (int i=0;i<bunch.length;i++){
            // keep same spirit as your code: ignore 0 grades
            if (bunch[i].getGrade() != 0){
                s += bunch[i].getGrade();
                n++;
            }
        }
        return n == 0 ? Double.NaN : s / n;
    }

    // 5) search by name (ignore case here)
    public static Student findStudentByName(Student[] people, String nm){
        if (people == null) return null;
        for (int i=0;i<people.length;i++){
            if (people[i].getName().equalsIgnoreCase(nm)) return people[i];
        }
        return null;
    }

    // 6) sort by grade desc (simple selection sort, different from your bubble)
    public static void sortByGradeDesc(Student[] people){
        if (people == null) return;
        for (int i=0;i<people.length-1;i++){
            int maxPos = i;
            for (int j=i+1;j<people.length;j++){
                if (people[j].getGrade() > people[maxPos].getGrade()){
                    maxPos = j;
                }
            }
            if (maxPos != i){
                Student tmp = people[i];
                people[i] = people[maxPos];
                people[maxPos] = tmp;
            }
        }
    }

    // 7) print high achievers (>=15)
    public static void printHighAchievers(Student[] list){
        System.out.println("high flyers (>=15):");
        if (list == null) return;
        for (int i=0;i<list.length;i++){
            if (list[i].getGrade() >= 15){
                System.out.println(" -> " + list[i]);
            }
        }
    }

    // 8) update grade by id
    public static boolean updateGrade(Student[] herd, int sid, int newG){
        if (herd == null) return false;
        for (int i=0;i<herd.length;i++){
            if (herd[i].getId() == sid){
                herd[i].setGrade(newG);
                return true;
            }
        }
        return false;
    }

    // 9) duplicate names?
    public static boolean hasDuplicateNames(Student[] st){
        if (st == null) return false;
        for (int i=0;i<st.length;i++){
            for (int j=i+1;j<st.length;j++){
                if (st[i].getName().equalsIgnoreCase(st[j].getName())) return true;
            }
        }
        return false;
    }

    // 10) append student (expand 1 slot)
    public static Student[] appendStudent(Student[] st, Student newbie){
        if (st == null) st = new Student[0];
        Student[] out = Arrays.copyOf(st, st.length + 1);
        out[out.length - 1] = newbie;
        return out;
    }

    // 1) demo
    public static void main(String[] args){
        Student[] arr = new Student[5];
        arr[0] = new Student(1,"mehdi",19,15);
        arr[1] = new Student(2,"yassine",20);
        arr[2] = new Student(3,"marouane",25);
        arr[3] = new Student(4,"hamza",20);
        arr[4] = new Student(5,"mehdi",17,12);

        System.out.println("== roster ==");
        for (Student s: arr) System.out.println(s);
        System.out.println("count so far : " + Student.getNumStudent());

        System.out.println("\noldest -> " + findOldest(arr));
        System.out.println("adults  -> " + countAdults(arr));
        System.out.println("avg(ignoring zeros) -> " + averageGrade(arr));

        System.out.println("\nfind by name 'hamza':");
        System.out.println(findStudentByName(arr,"hamza"));

        sortByGradeDesc(arr);
        System.out.println("\n== sorted by grade desc ==");
        for (Student s: arr) System.out.println(s);

        System.out.println();
        printHighAchievers(arr);

        boolean ok = updateGrade(arr,4,19);
        System.out.println("\nupdated id=4 ? " + ok);
        System.out.println(findStudentByName(arr,"hamza"));

        System.out.println("\nany dup names ? " + (hasDuplicateNames(arr) ? "yes" : "no"));

        arr = appendStudent(arr, new Student(6,"othmane",16,18));
        System.out.println("\n== after append ==");
        for (Student s: arr) System.out.println(s);
        System.out.println("total created : " + Student.getNumStudent());
    }
}
