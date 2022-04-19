import java.util.Random;

public  String CreateSalt(){
	Random rand = new Random();
	int[] nums = new Random().ints(33, 176).limit(15).toArray();
	String Salt="";
	for (int n=0; n<15; ++n){
		Salt=Salt+(char)nums[n];
	}
	return Salt;
}
