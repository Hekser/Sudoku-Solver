package Generator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;

public class GameController implements Initializable {

    @FXML
    private TextField p92;

    @FXML
    private TextField p91;

    @FXML
    private TextField p94;

    @FXML
    private TextField p93;

    @FXML
    private TextField p52;

    @FXML
    private TextField p96;

    @FXML
    private TextField p51;

    @FXML
    private TextField p95;

    @FXML
    private TextField p54;

    @FXML
    private TextField p98;

    @FXML
    private TextField p53;

    @FXML
    private TextField p97;

    @FXML
    private TextField p12;

    @FXML
    private TextField p56;

    @FXML
    private TextField p11;

    @FXML
    private TextField p55;

    @FXML
    private TextField p99;

    @FXML
    private TextField p14;

    @FXML
    private TextField p58;

    @FXML
    private TextField p13;

    @FXML
    private TextField p57;

    @FXML
    private TextField p16;

    @FXML
    private TextField p15;

    @FXML
    private TextField p59;

    @FXML
    private TextField p18;

    @FXML
    private TextField p17;

    @FXML
    private TextField p19;

    @FXML
    private TextField p61;

    @FXML
    private TextField p63;

    @FXML
    private TextField p62;

    @FXML
    private TextField p21;

    @FXML
    private TextField p65;

    @FXML
    private TextField p64;

    @FXML
    private TextField p23;

    @FXML
    private TextField p67;

    @FXML
    private TextField p22;

    @FXML
    private TextField p66;

    @FXML
    private TextField p25;

    @FXML
    private TextField p69;

    @FXML
    private TextField p24;

    @FXML
    private TextField p68;

    @FXML
    private TextField p27;

    @FXML
    private TextField p26;

    @FXML
    private TextField p29;

    @FXML
    private TextField p28;

    @FXML
    private TextField p72;

    @FXML
    private TextField p71;

    @FXML
    private TextField p74;

    @FXML
    private TextField p73;

    @FXML
    private TextField p32;

    @FXML
    private TextField p76;

    @FXML
    private TextField p31;

    @FXML
    private TextField p75;

    @FXML
    private TextField p34;

    @FXML
    private TextField p78;

    @FXML
    private TextField p33;

    @FXML
    private TextField p77;

    @FXML
    private TextField p36;

    @FXML
    private MenuItem menuInfo;

    @FXML
    private TextField p35;

    @FXML
    private TextField p79;

    @FXML
    private TextField p38;

    @FXML
    private TextField p37;

    @FXML
    private TextField p39;

    @FXML
    private MenuItem menuClear;

    @FXML
    private TextField p81;

    @FXML
    private TextField p83;

    @FXML
    private TextField p82;

    @FXML
    private TextField p41;

    @FXML
    private TextField p85;

    @FXML
    private TextField p84;

    @FXML
    private TextField p43;

    @FXML
    private TextField p87;

    @FXML
    private MenuItem menuGeneruj;

    @FXML
    private TextField p42;

    @FXML
    private TextField p86;

    @FXML
    private TextField p45;

    @FXML
    private TextField p89;

    @FXML
    private TextField p44;

    @FXML
    private TextField p88;

    @FXML
    private TextField p47;

    @FXML
    private TextField p46;

    @FXML
    private TextField p49;

    @FXML
    private TextField p48;

    private GameGenerator gameGenerator;
    private TextField [][] textField;
    
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		gameGenerator = new GameGenerator();
		textField = new TextField[][] {{p11, p12, p13, p14, p15, p16, p17, p18, p19},
										{p21, p22, p23, p24, p25, p26, p27, p28, p29},
										{p31, p32, p33, p34, p35, p36, p37, p38, p39},
										{p41, p42, p43, p44, p45, p46, p47, p48, p49},
										{p51, p52, p53, p54, p55, p56, p57, p58, p59},
										{p61, p62, p63, p64, p65, p66, p67, p68, p69},
										{p71, p72, p73, p74, p75, p76, p77, p78, p79},
										{p81, p82, p83, p84, p85, p86, p87, p88, p89},
										{p91, p92, p93, p94, p95, p96, p97, p98, p99}};
		addMenuAction();
	}
	
	private void addMenuAction() {
        menuGeneruj.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	for (int i = 0; i < textField.length; ++i)
            		for (int j = 0; j < textField[i].length; ++j)
            		{
            			gameGenerator.setValue(i, j, textField[i][j].getText());
            		}
            	
               gameGenerator.start();
               
	           	for (int i = 0; i < textField.length; ++i)
	        		for (int j = 0; j < textField[i].length; ++j)
	        		{
	        			textField[i][j].setText(gameGenerator.getValue(i, j));
	        		}
            }
        });

        menuClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Clear();
            }
        });

        menuInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String aboutText = "       Gra Sudoku\n"
                        + "      wype³nij pola,\n  nastêpniej wybierz\n    Gra -> Generuj";
                createPopup(aboutText);
            }
        });
    }
	
	private void Clear()
	{
		//model = new Model();
		for (int i = 0; i < textField.length; ++i)
			for (int j = 0; j < textField[i].length; ++j)
			{
				textField[i][j].setText("");
			}
	}
	
    private Popup createPopup(String text) {
        TextArea popupText = new TextArea(text);
        popupText.setPrefWidth(160);
        popupText.setPrefHeight(100);
        popupText.setEditable(false);

        Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.getContent().addAll(popupText);

        popup.show(p11.getScene().getWindow());
        popup.addEventFilter(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        popup.hide();
                    }
                });

        return popup;
    }
}
