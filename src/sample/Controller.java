package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;
import org.omg.CORBA.Environment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Controller {

    private static final float STEP = 0.25f;
    private static ArrayList<Double> values;

    @FXML
    private Menu funcMenu;

    @FXML
    private MenuItem calc;


    @FXML
    private MenuItem max;


    @FXML
    private MenuItem min;


    @FXML
    private MenuItem sumAll;


    @FXML
    private MenuItem multAll;


    @FXML
    private MenuItem sumNeg;

    @FXML
    private MenuItem multNeg;

    @FXML
    private MenuItem sumPos;

    @FXML
    private MenuItem multPos;

    @FXML
    private MenuItem printPositive;

    @FXML
    private MenuItem printNegative;

    @FXML
    private TextField text;

    @FXML
    private TextArea out;

    @FXML
    private GridPane arrayGrid;

    @FXML
    private MenuItem exit;

    @FXML
    private MenuItem t;


    @FXML
    private AnchorPane mainMenu;


    @FXML
    public void initialize() {

        t = new MenuItem("Context menu");
        t.setVisible(false);

        final ContextMenu contextMenu = new ContextMenu(t);
        contextMenu.getItems().addAll(t, calc, max, min, sumAll, multAll, sumNeg, multNeg, sumPos, multPos, printPositive, printNegative, exit);

        contextMenu.setAutoHide(true);

        mainMenu.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(text, event.getScreenX(), event.getScreenY());
                }
            }
        });


        calc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (text.getText()) {
                    case "-3":
                        values = new ArrayList<Double>();
                        double a = Double.parseDouble(text.getText());
                        for (double i = 1; i <= 4; i += STEP) {
                            double z = Math.log(i + a);
                            double currValue = Math.log(i + a) / a;
                            values.add(currValue);
                        }

                        JOptionPane.showMessageDialog(null, "Function calculated!");
                        break;
                    case "4":

                        values = new ArrayList<Double>();
                        a = Double.parseDouble(text.getText());
                        double i = 1;
                         do{
                            double currValue = Math.sin(i) * a;
                             i += STEP;
                            values.add(currValue);
                        }while (i <= 4);

                        JOptionPane.showMessageDialog(null, "Function calculated!");
                        break;
                    case "6":

                        values = new ArrayList<Double>();
                        a = Double.parseDouble(text.getText());
                        i = 1;
                        while (i <= 4){
                            double currValue = a - 4 * i;
                            i += STEP;
                            values.add(currValue);
                        }

                        JOptionPane.showMessageDialog(null, "Function calculated!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Enter correct number!");
                        break;
                }
            }
        });

        max.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double max = 0;

                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite()) {
                            max = values.get(i);
                            break;
                        }
                    }

                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite()) {
                            if (values.get(i) > max) {
                                max = values.get(i);
                            }
                        }
                    }

                    out.setText(String.valueOf(max));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }
            }

        });

        min.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double min = 0;

                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite()) {
                            min = values.get(i);
                            break;
                        }
                    }

                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite()) {
                            if (values.get(i) < min) {
                                min = values.get(i);
                            }
                        }
                    }

                    out.setText(String.valueOf(min));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }

            }
        });

        sumAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double sum = 0;


                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite()) {
                            sum += values.get(i);
                        }
                    }
                    out.setText(String.valueOf(sum));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }
            }
        });


        multAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double mult = 1;
                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite()) {
                            mult *= values.get(i);
                        }
                    }
                    out.setText(String.valueOf(mult));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }
            }
        });


        sumNeg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double sum = 0;


                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite() && values.get(i) < 0) {
                            sum += values.get(i);
                        }
                    }
                    out.setText(String.valueOf(sum));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }
            }
        });

        multNeg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double mult = 1;
                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite() && values.get(i) < 0) {
                            mult *= values.get(i);
                        }
                    }
                    out.setText(String.valueOf(mult));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }
            }
        });

        sumPos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double sum = 0;


                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite() && values.get(i) > 0) {
                            sum += values.get(i);
                        }
                    }
                    out.setText(String.valueOf(sum));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }
            }
        });

        multPos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (values != null) {
                    double mult = 1;
                    for (int i = 0; i < values.size(); i++) {
                        if (!values.get(i).isNaN() && !values.get(i).isInfinite() && values.get(i) > 0) {
                            mult *= values.get(i);
                        }
                    }
                    out.setText(String.valueOf(mult));
                } else {
                    JOptionPane.showMessageDialog(null, "Calculate function!");
                }

            }
        });


        printNegative.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                boolean isNegativeHas = false;

                if (values != null) {
                    for (int i = 0; i < values.size(); i++) {
                        if (values.get(i) < 0) {
                            isNegativeHas = true;
                            break;
                        }
                    }
                }

                if (values != null && values.size() != 0 && isNegativeHas) {
                    arrayGrid.getChildren().clear();
                    arrayGrid.setGridLinesVisible(true);
                    arrayGrid.add(new Label("Negative elements"), 0, 0);
                    for (int i = 0; i < values.size(); i++) {
                        if (values.get(i) < 0)
                            arrayGrid.add(new Label(String.valueOf(values.get(i))), 0, i + 1);
                    }

                    arrayGrid.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Negative elements not found!");
                }
            }
        });

        printPositive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                boolean isPositiveHas = false;

                if (values != null) {
                    for (int i = 0; i < values.size(); i++) {
                        if (values.get(i) > 0) {
                            isPositiveHas = true;
                            break;
                        }
                    }
                }


                if (values != null && values.size() != 0 && isPositiveHas) {
                    arrayGrid.getChildren().clear();
                    arrayGrid.setGridLinesVisible(true);
                    arrayGrid.add(new Label("Positive elements"), 0, 0);
                    for (int i = 0; i < values.size(); i++) {
                        if (values.get(i) > 0)
                            arrayGrid.add(new Label(String.valueOf(values.get(i))), 0, i + 1);
                    }

                    arrayGrid.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Positive elements not found!");
                }
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int response = JOptionPane.showConfirmDialog(null, "Are you sure?");

                if (response == JOptionPane.YES_OPTION) {
                    Platform.exit();
                }
            }
        });

    }
}
