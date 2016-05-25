/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.TriangleMesh;

/**
 *
 * @author user
 */
public class Room3Ob extends TriangleMesh{
    int radius = 20;
    int height = 30;
    public Room3Ob(){
        
        paint();
    }
    public void paint(){
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.BLUE);
        material1.setSpecularColor(Color.LIGHTBLUE);
        material1.setSpecularPower(5.0);
     
  
        

        //height *= .5f;

        float points[] = {
            80, 0, 20,//0
            100, 0, 20,//1
            40, 0, 60,//2
            60, 0, 60,//3
            80, 80,20,//4
            100, 100,20,//5
            40, 80,60,//6
            60, 100,60,//7
            40, 80,20,//8    
            0, 80, 60,//9
            40, 100,20,//10
            0, 100, 60 //11
    
        };
        float texcoords[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

  




   
        int faces[] = {
            7,0,9,0, 11,0,
            6,0,9,0, 7,0, 
    
            2,0, 6,0, 7,0,
            2,0, 7,0, 3,0,
            1,0,3,0, 7,0, 
            1,0,7,0,5,0,    
    
            1,0, 5,0,4,0,
            4,0,0,0, 1,0,
    
            5,0,8,0, 4,0, 
            5,0, 10,0,8,0, 
            8,0, 10,0, 11,0,
            8,0, 11,0, 9,0,
            0,0, 4,0, 6,0,
            0,0, 6,0, 2,0,
    
            0,0, 2,0, 3,0,
            0,0, 3,0, 1,0, 
            6,0, 8,0, 9,0, 
            4,0,8,0, 6,0,
      
            5,0,7,0,10,0, 
            7,0, 11,0,10,0
        };
       

        // Faces


        // build cap faces
      

        int smoothing[] = {};


        getPoints().addAll(points);
        getTexCoords().addAll(texcoords);
        getFaces().addAll(faces);
        getFaceSmoothingGroups().addAll( smoothing);
    }
}
