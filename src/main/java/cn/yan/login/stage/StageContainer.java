package cn.yan.login.stage;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Stage容器
 */
public class StageContainer{

	private static Map<String,Stage> map = new HashMap();


	public static Stage getStage(Class<? extends Stage> stageClazz){
		String clazzName = stageClazz.getName();
		return map.get(clazzName);
	}



	public static void putStage(Class<? extends Stage> stageClazz,Stage stage){
		String clazzName = stageClazz.getName();
		map.put(clazzName, stage);
	}



	public static void deleteStage(Class<? extends Stage> stageClazz){
		String clazzName = stageClazz.getName();
		map.remove(clazzName);
	}



}
