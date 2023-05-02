import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String currentTime = sc.nextLine();
		String targetTime = sc.nextLine();
		
		// 현재 시간을 초로 변환
		// 타겟 시간을 초로 변환
		// 절대값으로 두 시간의 차이를 구함
		// 구해진 시간을 다시 시 분 초로 변환하여 hh:mm:ss로 출력
		
		// 시 분 초 구하는 방법
		// 방법 1. charAt()을 이용
//		int currentHour = (currentTime.charAt(0)-'0')*10 + (currentTime.charAt(1)-'0');
//		int currentMinute = (currentTime.charAt(3)-'0')*10 + (currentTime.charAt(4)-'0');
//		int currentSecond = (currentTime.charAt(6)-'0')*10 + (currentTime.charAt(7)-'0');
//		
//		int targetHour = (targetTime.charAt(0)-'0')*10 + (targetTime.charAt(1)-'0');
//		int targetMinute = (targetTime.charAt(3)-'0')*10 + (targetTime.charAt(4)-'0');
//		int targetSecond = (targetTime.charAt(6)-'0')*10 + (targetTime.charAt(7)-'0');
		
		// 방법 2. substring()을 이용
//		int currentHour = Integer.parseInt(currentTime.substring(0,2));
//		int currentMinute = Integer.parseInt(currentTime.substring(3,5));
//		int currentSecond = Integer.parseInt(currentTime.substring(6,8));
//		
//		int targetHour = Integer.parseInt(targetTime.substring(0,2));
//		int targetMinute = Integer.parseInt(targetTime.substring(3,5));
//		int targetSecond = Integer.parseInt(targetTime.substring(6,8));
		
		// 방법 3. split()을 이용
		String[] time = currentTime.split(":");
		int currentHour = Integer.parseInt(time[0]);
		int currentMinute = Integer.parseInt(time[1]);
		int currentSecond = Integer.parseInt(time[2]);
		
		time = targetTime.split(":");
		int targetHour = Integer.parseInt(time[0]);
		int targetMinute = Integer.parseInt(time[1]);
		int targetSecond = Integer.parseInt(time[2]);
		
//		System.out.println(currentHour);
//		System.out.println(currentMinute);
//		System.out.println(currentSecond);
//		System.out.println(targetHour);
//		System.out.println(targetMinute);
//		System.out.println(targetSecond);
		
		// 추출한 시 분 초를 초로 변환
		int currentTimeTotalSecond = currentHour*3600 + currentMinute*60 + currentSecond;
		int targetTimeTotalSecond = targetHour*3600 + targetMinute*60 + targetSecond;
		
		int resultTimeTotalSecond = targetTimeTotalSecond- currentTimeTotalSecond;
		// 0초가 나오면 안되기 때문에
		if(resultTimeTotalSecond <= 0) 
			resultTimeTotalSecond += 24*3600;			
		
		int resultHour = resultTimeTotalSecond / 3600;
		int resultMinute = (resultTimeTotalSecond % 3600) / 60;
		int resultSecond = resultTimeTotalSecond % 60;
		
		// 출력
		// 방법 1. 변환 후 출력
//		String answer = String.format("%02d:%02d:%02d", resultHour, resultMinute, resultSecond);
//		System.out.println(answer);
		// 방법 2. printf로 출력
		System.out.printf("%02d:%02d:%02d", resultHour, resultMinute, resultSecond);
		
	}
}
