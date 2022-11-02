import java.util.ArrayList;

public class Course {
    private ArrayList<int []> lectures = new ArrayList<>();
    private String courseCode;

    private boolean are_tuples_same(int[] tuple1, int[] tuple2){
        if (tuple1[0] == tuple2[0] && tuple1[1] == tuple2[1]) {
            return true;
        }
        return false;
    }

    public Course(String courseCode){
        this.courseCode =courseCode;
    }

    public String getCode(){
        return courseCode;
    }

    public boolean hasLectureOn(int day) {
        for (int[] tuple : this.lectures) {
            if (tuple[0] == day) {
                return true;
            }
        }
        return false;
    }
    public void addLecture (int day, int hour){
        if (0<day && day<6 && 7<hour && hour<18){
            int[] newtuple = {day, hour};
            if (this.lectures.isEmpty()){
                this.lectures.add(newtuple);
            }
            else{
                for (int i = 0; i< this.lectures.size(); i++){
                    if (are_tuples_same(newtuple, this.lectures.get(i))){
                        return;
                    }
                }
                this.lectures.add(newtuple);
            }
        }
    }

    public boolean hasLectureAt(int day, int hour){
        for (int[] tuple : this.lectures) {
            if (tuple[0] == day && tuple [1] == hour) {
                return true;
            }
        }
        return false;
    }

    public boolean conflictsWith(Course other){
        for (int [] time : this.lectures){
            if(other.hasLectureAt(time[0],time[1])) {
                return true;
            }
        }
        return false;
    }
}
