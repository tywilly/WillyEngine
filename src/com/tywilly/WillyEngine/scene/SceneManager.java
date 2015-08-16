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

		if(!currentScene.isLoaded()){
			currentScene.onCreateSuper();
		}
		
	}
	
	/**
	 * Swap current scene with a new scene
	 * @param newScene A new scene object
	 * @return returns the old scene object
	 */
	public static Scene swapScene(Scene newScene){
		
		Scene rScene = currentScene;
		
		currentScene = newScene;
		
		if(!currentScene.isLoaded()){
			currentScene.onCreateSuper();
		}
		
		return rScene;
	}

	public static Scene getCurrentScene() {
		return currentScene;
	}

}
