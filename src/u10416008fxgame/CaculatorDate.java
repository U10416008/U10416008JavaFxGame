package u10416008fxgame;
//U10416008丁杰

import javafx.geometry.*;
import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import java.time.*;
import java.time.temporal.*;
import java.util.*;
import javafx.beans.value.*;
import javafx.scene.text.*;
import java.security.SecureRandom;


public class CaculatorDate extends Application {
	LocalDate getStart;
	LocalDate getEnd ;
        LocalDate guess ;
        LocalDate birth = LocalDate.of(1879, 3, 14);
        TextField minusDate = new TextField();
	TextField minusDay = new TextField();
        Text guessWhose = new Text("愛因斯坦的生日是?");
        Text guessCorrect = new Text();
        SecureRandom srand = new SecureRandom();
        String person[] = {"愛因斯坦", "愛迪生" , "正妹" ,"帥哥","莫札特","皮卡丘","安徒生","愛新覺羅‧溥儀"};
	long betweenDay;
	long betweenYear;
	long betweenMonth;
	long betweenWeek;
	long betweenDay2;
	boolean minusMonth = false;
	boolean minusYear = false;
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Label date = new Label("Almighty Calender");
		FlowPane grid = new FlowPane();
		ObservableList<String> items = FXCollections.observableArrayList(
			"計算兩個日期間的差距","猜生日");
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		Button[] bts = new Button[28];
		date.setStyle("-fx-stroke: #3278fa;-fx-text-fill: RED;-fx-font-size: 54;");
		ChoiceBox cB = new ChoiceBox(items);
		cB.setStyle("-fx-background-color: PINK;");
		cB.setMaxWidth(Double.MAX_VALUE);		
		DatePicker startDay = new DatePicker();
		DatePicker endDay = new DatePicker();
                DatePicker guessDay = new DatePicker();
		Button compute = new Button("計算");
                Button change = new Button("換人");
		Label start = new Label("從");
		Label end = new Label("到");
		Label minus = new Label("差異年、月、週、日");		
		minusDate.setEditable(false);
		Label minus2 = new Label("差異天");                
		minusDay.setEditable(false);
		HBox hb = new HBox();
                HBox hb2 = new HBox();
		hb.getChildren().addAll(start, startDay, end, endDay);
		hb.setSpacing(50);
                hb2.getChildren().addAll(guessWhose,change);
		hb2.setSpacing(50);
		VBox vb = new VBox();
		vb.getChildren().addAll(date, cB );
                vb.setSpacing(30);
                vb.setPadding(new Insets(10, 0, 0, 10));
		vb.setMargin(compute , new Insets(0,0,0,440));
		compute.setPrefSize(100,20);
		compute.setOnAction(e ->{
                    if(vb.getChildren().contains(hb) == true){
                        getStart = startDay.getValue();
                        getEnd = endDay.getValue();
                        computeDate();
                    }
                    if(vb.getChildren().contains(guessDay) == true){
                        guess = guessDay.getValue();
                        guessBirth();
                    }
		});
                change.setOnAction(e ->{
                   setPerson(); 
                });
                guessCorrect.setStyle("-fx-stroke: #3278fa;-fx-text-fill: RED;-fx-font-size: 54;");
                
		cB.getSelectionModel().selectedIndexProperty().addListener(
                        new ChangeListener<Number>(){
                            @Override
                            public void changed(ObservableValue ov,Number value,Number new_value){
                                if(new_value.intValue() == 0){
                                    if(vb.getChildren().contains(guessDay) == true){
                                        vb.getChildren().removeAll(hb2,guessDay,guessCorrect,compute);
                                    }
                                    if(vb.getChildren().contains(minus) == false){
                                        vb.getChildren().addAll(hb,minus, minusDate, minus2 ,minusDay,compute);
                                    }
                                    
                                    compute.setText("計算");
                                }
                                if(new_value.intValue() == 1){
                                    if(vb.getChildren().contains(minus) == true){
                                        vb.getChildren().removeAll(hb,minus, minusDate, minus2 ,minusDay,compute);   
                                    }
                                    if(vb.getChildren().contains(guessDay) == false){
                                        vb.getChildren().addAll(hb2,guessDay,guessCorrect,compute);
                                    }
                                    guessCorrect.setText("");
                                    compute.setText("猜");
                                }
                            }
                        }
                );
		grid.getChildren().addAll(vb);
		grid.setStyle(
			"-fx-text-fill: #FFFFFF; -fx-border-color: red; -fx-background-color: WHITE;");    
		Scene scene = new Scene(grid, 600, 500);
		primaryStage.setTitle("Calender"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
    /*public static void main(String[] args) {
        launch(args);
    }*/
    public void computeDate(){
        betweenDay = ChronoUnit.DAYS.between(getStart, getEnd);
        if(getEnd.getDayOfMonth() >= getStart.getDayOfMonth()){
            betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth();
        }else{
            minusMonth = true ;
            //System.out.println(getEnd.getDayOfMonth());
            switch(getEnd.getMonthValue()){
                case 1 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 2 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 3 :
                    if(getEnd.isLeapYear() == true){
                        betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 29;
                    }else{
                        betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 28;
                    }
                    break;
                case 4 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 5 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 30;break;
                case 6 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 7 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 30;break;
                case 8 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 9 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 10 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 30;break;
                case 11 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 31;break;
                case 12 : betweenDay2 = getEnd.getDayOfMonth() - getStart.getDayOfMonth() + 30;
                }
        }
        betweenWeek = betweenDay2 / 7;
        betweenDay2 = betweenDay2 % 7 ;
			
        if(minusMonth == true){
            if(getEnd.getMonthValue() - 1 >= getStart.getMonthValue()){
                betweenMonth = getEnd.getMonthValue() - 1 - getStart.getMonthValue();
            }else{
                betweenMonth = getEnd.getMonthValue() - 1 - getStart.getMonthValue() + 12;
                minusYear = true ;
            }
            minusMonth = false ; 
	}else{
            if(getEnd.getMonthValue() >= getStart.getMonthValue()){
                betweenMonth = getEnd.getMonthValue() - getStart.getMonthValue();
            }else{
                betweenMonth = getEnd.getMonthValue() - getStart.getMonthValue() + 12;
                minusYear = true ;
            }
        }
        if(minusYear == true){
            betweenYear = getEnd.getYear() - 1 - getStart.getYear();
            minusYear = false;
        }else{
            betweenYear = getEnd.getYear() - getStart.getYear();
        }
        minusDate.setText(String.valueOf(betweenDay2) + "天，" + String.valueOf(betweenWeek) + "週，" + String.valueOf(betweenMonth) + "月，" + String.valueOf(betweenYear) + "年");
			
        minusDay.setText(String.valueOf(betweenDay)+"天");
    }
    public void guessBirth(){
        if(guess.compareTo(birth) != 0){
            if(guess.getYear() != birth.getYear()){
                if(guess.getYear() < birth.getYear()){
                    guessCorrect.setText("Guess Bigger Year");
                }
                if(guess.getYear() > birth.getYear()){
                    guessCorrect.setText("Guess Smaller Year");
                }
            }else if(guess.getMonthValue() != birth.getMonthValue()){
                if(guess.getMonthValue() < birth.getMonthValue()){
                    guessCorrect.setText("Guess Bigger Month");
                }
                if(guess.getMonthValue() > birth.getMonthValue()){
                    guessCorrect.setText("Guess Smaller Month");
                }
            }else if(guess.getDayOfMonth() != birth.getDayOfMonth()){
                if(guess.getDayOfMonth() < birth.getDayOfMonth()){
                    guessCorrect.setText("Guess Bigger Day");
                }
                if(guess.getDayOfMonth() > birth.getDayOfMonth()){
                    guessCorrect.setText("Guess Smaller Day");
                }
            }
        }else{
            guessCorrect.setText("Correct!!");
            guessWhose.setText(guessWhose.getText() +"  "+ birth);
        }
    }
    public void setPerson(){
        int i = srand.nextInt(person.length);
        guessWhose.setText(person[i] + "的生日是?");
        switch(i){
            case 0 : birth = LocalDate.of(1879, 3, 14);break;
            case 1 : birth = LocalDate.of(1847, 2, 11);break;
            case 2 : birth = LocalDate.of(1997, 4, 18);break;
            case 3 : birth = LocalDate.of(1996, 11, 4);break;
            case 4 : birth = LocalDate.of(1756, 1, 27);break;
            case 5 : birth = LocalDate.of(1996, 2, 27);break;
            case 6 : birth = LocalDate.of(1805, 4,  2);break;
            case 7 : birth = LocalDate.of(1906, 2,  7);break;
            default : break;
        }
    }
}
