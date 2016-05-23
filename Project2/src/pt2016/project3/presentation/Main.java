package pt2016.project3.presentation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		new Controller(new ViewFrame());
		
	}
	
	public List<Field> getFields(Class<?> entity) {
		List<Field> result = new LinkedList<>();
		for(Class<?> c = entity; c != null; c = c.getSuperclass()) {
			result.addAll(Arrays.asList(c.getDeclaredFields()));
		}
		return result;
	}
	
	public String[] getFieldNames(Class<?> entity) {
		List<Field> fields = getFields(entity);
		String[] result = new String[fields.size()];
		int it = 0;
		for (Field field : fields) {
			result[it++] = field.getName();
		}
		return result;
	}
}
