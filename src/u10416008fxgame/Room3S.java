/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.scene.shape.TriangleMesh;

/**
 *
 * @author user
 */
public class Room3S extends TriangleMesh{
    public Room3S(){
        
    }
    public void paintS(){
        int divisions = 75;
        float r = 50;
        float R = 100;
        float point[] = new float[3*divisions*8];
        int k = 0;
        for(int i = 0; i < divisions; i++){
            
            point[k] = (float)(R*Math.cos(3f/4f/(divisions-1) * i  * 2*Math.PI));
            point[k+1] = -R - (float)(R*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 0;
            k = k+3;
            
            point[k] = (float)(r*Math.cos((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+1] = -R - (float)(r*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 0;
            k = k+3;
            
        }
        for(int i = 1; i < divisions; i++){
            
            point[k] = (float)(r*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(r*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 0;
            k = k+3;
            
            point[k] = (float)(R*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(R*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 0;
            k = k+3;
            
        }
        for(int i = 0; i < divisions; i++){
            
            point[k] = (float)(R*Math.cos((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+1] = -R - (float)(R*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 50;
            k = k+3;
            
            point[k] = (float)(r*Math.cos((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+1] = -R - (float)(r*Math.sin((3f/4f/(divisions-1)) * 2 * Math.PI * i));
            point[k+2] = 50;
            k = k+3;
            
        }
        for(int i = 1; i < divisions; i++){
            
            point[k] = (float)(r*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(r*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 50;
            k = k+3;
            
            point[k] = (float)(R*Math.cos((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ));
            point[k+1] = -(float)(R*Math.sin((1f/4f - (3f/4f/(divisions-1))* i) * 2 * Math.PI ))+r;
            point[k+2] = 50;
            k = k+3;
            
        }
        float tex[] = {0,0};
        int faces[] = new int[6*2*4*(2*(divisions-1))+24];
        int f = 0;
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+2;
            faces[f+3] = 0;
            faces[f+4] = i+1;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+1;
            faces[f+1] = 0;
            faces[f+2] = i+2;
            faces[f+3] = 0;
            faces[f+4] = i+3;
            faces[f+5] = 0;
            f = f+6;
            
        }
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i+298;
            faces[f+1] = 0;
            faces[f+2] = i+299;
            faces[f+3] = 0;
            faces[f+4] = i+300;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+299;
            faces[f+1] = 0;
            faces[f+2] = i+301;
            faces[f+3] = 0;
            faces[f+4] = i+300;
            faces[f+5] = 0;
            f = f+6;
            
        }
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+298;
            faces[f+3] = 0;
            faces[f+4] = i+300;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+300;
            faces[f+3] = 0;
            faces[f+4] = i+2;
            faces[f+5] = 0;
            f = f+6;
            
        }
        for(int i = 0 ; i < 4*(divisions-1) ; i = i+2){
            faces[f] = i+1;
            faces[f+1] = 0;
            faces[f+2] = i+3;
            faces[f+3] = 0;
            faces[f+4] = i+299;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+3;
            faces[f+1] = 0;
            faces[f+2] = i+301;
            faces[f+3] = 0;
            faces[f+4] = i+299;
            faces[f+5] = 0;
            f = f+6;
            
        }
        faces[f] = 0;
        faces[f+1] = 0;
        faces[f+2] = 299;
        faces[f+3] = 0;
        faces[f+4] = 298;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 0;
        faces[f+1] = 0;
        faces[f+2] = 1;
        faces[f+3] = 0;
        faces[f+4] = 299;
        faces[f+5] = 0;
        f = f+6;
        
        faces[f] = 296;
        faces[f+1] = 0;
        faces[f+2] = 594;
        faces[f+3] = 0;
        faces[f+4] = 595;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 296;
        faces[f+1] = 0;
        faces[f+2] = 595;
        faces[f+3] = 0;
        faces[f+4] = 297;
        faces[f+5] = 0;
        f = f+6;
        
        getPoints().clear();
        getTexCoords().clear();
        getFaces().clear();
        getPoints().addAll(point);
        getTexCoords().addAll(tex);
        getFaces().addAll(faces);
        
        
    }
    public void paintA(){
        float w = 75;
        float h = 300;
        float point[] ={
                  0,    0,  0,
               -w/2,   -w,  0,
                w/2,   -w,  0,
               -w/2,    w,  0,
                w/2,    w,  0,
                 -w,  2*w,  0,
                  w,  2*w,  0,
            -2.5f*w,  h-w,  0,
            -1.5f*w,  h-w,  0,
             1.5f*w,  h-w,  0,
             2.5f*w,  h-w,  0,
                  0,    0, 50,
               -w/2,   -w, 50,
                w/2,   -w, 50,
               -w/2,    w, 50,
                w/2,    w, 50,
                 -w,  2*w, 50,
                  w,  2*w, 50,
            -2.5f*w,  h-w, 50,
            -1.5f*w,  h-w, 50,
             1.5f*w,  h-w, 50,
             2.5f*w,  h-w, 50
            
        };
        float tex[] = {0,0};
        int faces[] = {
             0, 0, 2, 0, 1, 0,
             0, 0, 1, 0, 7, 0,
             0, 0, 7, 0, 8, 0,
             3, 0, 5, 0, 4, 0,
             4, 0, 5, 0, 6, 0,
             0, 0,10, 0, 2, 0,
             0, 0, 9, 0,10, 0,
            11, 0,12, 0,13, 0,
            11, 0,18, 0,12, 0,
            11, 0,19, 0,18, 0,
            14, 0,15, 0,16, 0,
            15, 0,17, 0,16, 0,
            11, 0,13, 0,21, 0,
            11, 0,21, 0,20, 0,
             1, 0, 2, 0,12, 0,
             1, 0, 2, 0,12, 0,
             2, 0,13, 0,12, 0,
             7, 0, 1, 0,18, 0,
            18, 0, 1, 0,12, 0,
            18, 0, 8, 0, 7, 0,
            18, 0,19, 0, 8, 0,
             8, 0,16, 0, 5, 0,
             8, 0,19, 0,16, 0,
             5, 0,16, 0, 6, 0,
            16, 0,17, 0, 6, 0,
             3, 0,15, 0,14, 0,
             3, 0, 4, 0,15, 0,
             0, 0, 3, 0,11, 0,
             3, 0,14, 0,11, 0,
             0, 0,11, 0, 4, 0,
             4, 0,11, 0,15, 0,
             6, 0,17, 0, 9, 0,
             9, 0,17, 0,20, 0,
             9, 0,20, 0,21, 0,
             9, 0,21, 0,10, 0,
             2, 0,10, 0,21, 0,
             2, 0,21, 0,13, 0
        };
        getPoints().clear();
        getTexCoords().clear();
        getFaces().clear();
        getPoints().addAll(point);
        getTexCoords().addAll(tex);
        getFaces().addAll(faces);
    }
    public void paintC(){
        int divisions = 100;
        float r = 100;
        float R = 150;
        int k = 0;
        float point[] = new float[4*(divisions+1)*3];
        for(int i = 0; i <= divisions ; i++){
            
            point[k] = (float)(R*Math.cos((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+1] = -(float)(R*Math.sin((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+2] = 0;
            k = k+3;
            
            point[k] = (float)(r*Math.cos((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+1] = -(float)(r*Math.sin((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+2] = 0;
            k = k+3;
        }
        for(int i = 0; i <= divisions ; i++){
            
            point[k] = (float)(R*Math.cos((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+1] = -(float)(R*Math.sin((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+2] = 50;
            k = k+3;
            
            point[k] = (float)(r*Math.cos((1f/12f + 10f/12f/divisions * i)* 2 * Math.PI ));
            point[k+1] = -(float)(r*Math.sin((1f/12f + 10f/12f/divisions * i) * 2 * Math.PI ));
            point[k+2] = 50;
            k = k+3;
        }
        float tex[] = {0,0};
        int f = 0;
        int faces[] = new int[12*(4*divisions+2)];
        for(int i = 0 ;i< 2 * divisions ; i = i+2){
            
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+2;
            faces[f+3] = 0;
            faces[f+4] = i+1;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+1;
            faces[f+1] = 0;
            faces[f+2] = i+2;
            faces[f+3] = 0;
            faces[f+4] = i+3;
            faces[f+5] = 0;
            f = f+6;
            
            faces[f] = i+202;
            faces[f+1] = 0;
            faces[f+2] = i+203;
            faces[f+3] = 0;
            faces[f+4] = i+204;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+203;
            faces[f+1] = 0;
            faces[f+2] = i+205;
            faces[f+3] = 0;
            faces[f+4] = i+204;
            faces[f+5] = 0;
            f = f+6;
            
            faces[f] = i+1;
            faces[f+1] = 0;
            faces[f+2] = i+3;
            faces[f+3] = 0;
            faces[f+4] = i+203;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+203;
            faces[f+1] = 0;
            faces[f+2] = i+3;
            faces[f+3] = 0;
            faces[f+4] = i+205;
            faces[f+5] = 0;
            f = f+6;
            
            faces[f] = i;
            faces[f+1] = 0;
            faces[f+2] = i+202;
            faces[f+3] = 0;
            faces[f+4] = i+2;
            faces[f+5] = 0;
            f = f+6;
            faces[f] = i+2;
            faces[f+1] = 0;
            faces[f+2] = i+202;
            faces[f+3] = 0;
            faces[f+4] = i+204;
            faces[f+5] = 0;
            f = f+6;
        }
        faces[f] = 0;
        faces[f+1] = 0;
        faces[f+2] = 203;
        faces[f+3] = 0;
        faces[f+4] = 202;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 0;
        faces[f+1] = 0;
        faces[f+2] = 1;
        faces[f+3] = 0;
        faces[f+4] = 203;
        faces[f+5] = 0;
        f = f+6;
        
        faces[f] = 200;
        faces[f+1] = 0;
        faces[f+2] = 402;
        faces[f+3] = 0;
        faces[f+4] = 201;
        faces[f+5] = 0;
        f = f+6;
        faces[f] = 201;
        faces[f+1] = 0;
        faces[f+2] = 402;
        faces[f+3] = 0;
        faces[f+4] = 403;
        faces[f+5] = 0;
        f = f+6;
        
        getPoints().clear();
        getTexCoords().clear();
        getFaces().clear();
        getPoints().addAll(point);
        getTexCoords().addAll(tex);
        getFaces().addAll(faces);
    }
    public void paintD(){
        float r = 100;
        float R = 200;
        int divisions = 50 ;
        float point[] = new float[3*(4*(divisions+1)+4)];
        int k = 0;
        for(int i = 0 ; i <= divisions ; i++){
            
            point[k] = (float)(r*Math.cos((1f/4f - 1f/2f/divisions*i)*2*Math.PI));
            point[k+1] = -(float)(r*Math.sin((1f/4f - 1f/2f/divisions*i)*2*Math.PI));
            point[k+2] = 0;
            k = k+3;
            
            point[k] = (float)(R*Math.cos((1f/3f - 2f/3f/divisions*i)*2*Math.PI));
            point[k+1] = -(float)(R*Math.sin((1f/3f - 2f/3f/divisions*i)*2*Math.PI));
            point[k+2] = 0;
            k = k+3;
        }
        for(int i = 0 ; i <= divisions ; i++){
            
            point[k] = (float)(r*Math.cos((1f/4f - 1f/2f/divisions*i)*2*Math.PI));
            point[k+1] = -(float)(r*Math.sin((1f/4f - 1f/2f/divisions*i)*2*Math.PI));
            point[k+2] = 50;
            k = k+3;
            
            point[k] = (float)(R*Math.cos((1f/3f - 2f/3f/divisions*i)*2*Math.PI));
            point[k+1] = -(float)(R*Math.sin((1f/3f - 2f/3f/divisions*i)*2*Math.PI));
            point[k+2] = 50;
            k = k+3;
        }
        
        float tex[] = {0,0};
        int p = 0;
        int faces[] = new int[(divisions*4  + 6)*12];
        for(int i = 0; i<2*divisions ; i = i+2){
            faces[p] = i;
            faces[p+1] = 0;
            faces[p+2] = i+2;
            faces[p+3] = 0;
            faces[p+4] = i+1;
            faces[p+5] = 0;
            p = p+6;
            faces[p] = i+1;
            faces[p+1] = 0;
            faces[p+2] = i+2;
            faces[p+3] = 0;
            faces[p+4] = i+3;
            faces[p+5] = 0;
            p = p+6;
            
            faces[p] = i;
            faces[p+1] = 0;
            faces[p+2] = i+102;
            faces[p+3] = 0;
            faces[p+4] = i+104;
            faces[p+5] = 0;
            p = p+6;
            faces[p] = i;
            faces[p+1] = 0;
            faces[p+2] = i+104;
            faces[p+3] = 0;
            faces[p+4] = i+2;
            faces[p+5] = 0;
            p = p+6;
            
            faces[p] = i+102;
            faces[p+1] = 0;
            faces[p+2] = i+103;
            faces[p+3] = 0;
            faces[p+4] = i+104;
            faces[p+5] = 0;
            p = p+6;
            faces[p] = i+104;
            faces[p+1] = 0;
            faces[p+2] = i+103;
            faces[p+3] = 0;
            faces[p+4] = i+105;
            faces[p+5] = 0;
            p = p+6;
            
            faces[p] = i+1;
            faces[p+1] = 0;
            faces[p+2] = i+3;
            faces[p+3] = 0;
            faces[p+4] = i+103;
            faces[p+5] = 0;
            p = p+6;
            faces[p] = i+3;
            faces[p+1] = 0;
            faces[p+2] = i+105;
            faces[p+3] = 0;
            faces[p+4] = i+103;
            faces[p+5] = 0;
            p = p+6;
        }
        faces[p] = 0;
        faces[p+1] = 0;
        faces[p+2] = 100;
        faces[p+3] = 0;
        faces[p+4] = 102;
        faces[p+5] = 0;
        p = p+6;
        faces[p] = 100;
        faces[p+1] = 0;
        faces[p+2] = 202;
        faces[p+3] = 0;
        faces[p+4] = 102;
        faces[p+5] = 0;
        p = p+6;
        
        faces[p] = 1;
        faces[p+1] = 0;
        faces[p+2] = 103;
        faces[p+3] = 0;
        faces[p+4] = 101;
        faces[p+5] = 0;
        p = p+6;
        faces[p] = 103;
        faces[p+1] = 0;
        faces[p+2] = 203;
        faces[p+3] = 0;
        faces[p+4] = 101;
        faces[p+5] = 0;
        p = p+6;
        
        faces[p] = 0;
        faces[p+1] = 0;
        faces[p+2] = 1;
        faces[p+3] = 0;
        faces[p+4] = 100;
        faces[p+5] = 0;
        p = p+6;
        faces[p] = 1;
        faces[p+1] = 0;
        faces[p+2] = 101;
        faces[p+3] = 0;
        faces[p+4] = 100;
        faces[p+5] = 0;
        p = p+6;
        
        faces[p] = 102;
        faces[p+1] = 0;
        faces[p+2] = 202;
        faces[p+3] = 0;
        faces[p+4] = 103;
        faces[p+5] = 0;
        p = p+6;
        faces[p] = 103;
        faces[p+1] = 0;
        faces[p+2] = 202;
        faces[p+3] = 0;
        faces[p+4] = 203;
        faces[p+5] = 0;
        p = p+6;
        
        getPoints().clear();
        getTexCoords().clear();
        getFaces().clear();
        getPoints().addAll(point);
        getTexCoords().addAll(tex);
        getFaces().addAll(faces);
    }
    
}
