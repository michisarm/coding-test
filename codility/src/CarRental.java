import java.util.*;
import java.text.SimpleDateFormat;

/**
 * 새로운 자동차 공유 앱을 통해 사용자는 특정 자동차를 렌트할 시간을 예약할 수 있습니다. 자동차 렌탈 시간 컬렉션이 주어지면 사용 시간에 대해 효율적으로 모든 렌탈 시간을 두 번 이상 겹치지 않고 예약할 수 있는지 확인하는 canScheduleAll 메서드를 구현합니다.
 *
 * 예를 들어 아래 대여 시간의 경우 메서드는 겹치지 않기 때문에 true를 반환해야 합니다.
 *
 * 2020-03-05 19:00-20:30
 * 2020-03-05 22:10-22:30
 * 2020-03-05 20:30-22:00
 */
public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {

        Map<Long,Long> obj = new HashMap<>();
        List list = Arrays.asList(rentalTimes.toArray());
        for (int i = 0; i < list.size(); i++) {
            RentalTime rentalTime = (RentalTime) list.get(i);
            obj.put(rentalTime.getStart().getTime(), rentalTime.getEnd().getTime());
        }
        for (RentalTime rentalTime : rentalTimes) {
            for (Map.Entry<Long, Long> o : obj.entrySet()) {
                if(o.getKey() < rentalTime.getStart().getTime() &&  rentalTime.getStart().getTime() < o.getValue()) {
                    return false;
                } else if(o.getKey() < rentalTime.getEnd().getTime() &&  rentalTime.getEnd().getTime() < o.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
//        rentalTimes.add(new RentalTime(sdf.parse("03/06/2020 22:10"), sdf.parse("03/06/2020 22:30")));
//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/07/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private Date start, end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}