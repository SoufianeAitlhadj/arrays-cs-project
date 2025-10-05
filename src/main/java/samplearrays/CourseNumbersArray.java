package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        /* 1) creating one array */
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        /* 2) adding one element to the array */
        int newCourse = 1012;
        int[] updatedCourses = new int[registeredCourses.length + 1 ];
        for (int i = 0; i < registeredCourses.length ;i++){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[updatedCourses.length - 1] = newCourse;

        System.out.println("List of updated courses :");

        /* 3) printing the array */
        for (int course : updatedCourses){
            System.out.println(course +" ");
        }

        /* 4) checking if a course exists in the array */
        for (int course : updatedCourses){
            if (course == 1020) {
                System.out.println("The course " + course + " exists");
            }
            else{
                System.out.println("The course " + course + " does not exist");
            }
        }


    }
}
