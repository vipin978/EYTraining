package day17;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	
	Object[][] obj = {
			{"Hi","Hello"}
	};
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
