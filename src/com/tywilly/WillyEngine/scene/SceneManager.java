/*Name:	
 *Date:
 *Period:
 *Teacher:
 *Description:
 */
package com.tywilly.WillyEngine.scene;

public class SceneManager {

	private static Scene currentScene = new Scene() {
		
		@Override
		public void onCreate() {
			// TODO Auto-generated method stub
			
		}
	};

	public static void loadScene(Scene scene) {
		currentScene = scene;

		currentScene.onCreate();
	}

	public static Scene getCurrentScene() {
		return currentScene;
	}

}
