import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

// Revision Block
// Date--------------------By-----------------------Reason----------------
// 9/29/2020        Steven Davies               First Version

public class gameController implements Initializable {

    // Get the Stage Control References
    @FXML
    private TextField txtgameName;

    @FXML
    private ComboBox<String> cmbPublishYear;

    @FXML
    private ComboBox<String> cmbIsPublished;

    @FXML
    private DatePicker dateReleaseDate;

    @FXML
    private ComboBox<String> cmbGameType;

    @FXML
    private TextField txtGamePrice;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Label lblWarningTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Add Published Options
        cmbIsPublished.getItems().add("True");
        cmbIsPublished.getItems().add("False");
        // Add Game Type Options
        cmbGameType.getItems().add("FPS");
        cmbGameType.getItems().add("2D Platformer");
        cmbGameType.getItems().add("3D Platformer");
        cmbGameType.getItems().add("Text Adventure");
        cmbGameType.getItems().add("MMO");

        // Add Year to ComboBox
        for (int a=1990; a < 2031 ; a++)
        {
            cmbPublishYear.getItems().add(String.valueOf(a));
        }

    }

    public void createButtonPushed()
    {
                    // Validation Section -----------------------------------------------------------------------------
                    // Param 1
                    /**
                     * Validate the input for the entered item, game name must be entered
                     * @param txtgameName
                     */
                    if (txtgameName.getText().isEmpty())
                    {
                        lblWarningTxt.setText("You need to enter the name of the Game!");
                        return;
                    } else
                        {
                           String theGameName = txtgameName.getText();
                        }
                    // Param 2
                    /**
                     * Validate the input for the entered item, publish year must be entered
                     * @param cmbPublishYear
                     */
                    if (cmbPublishYear.getSelectionModel().isEmpty())
                    {
                        lblWarningTxt.setText("You need to pick a year!");
                        return;
                    } else
                    {
                        String thePublishYear = cmbPublishYear.getValue();
                    }

                    // Param 3
                    /**
                     * Validate the input for the entered item, isPublished must be entered
                     * @param cmbIsPublished
                     */
                    if (cmbIsPublished.getSelectionModel().isEmpty())
                    {
                        lblWarningTxt.setText("Please select if the Game is Published or Not");
                        return;
                    } else
                    {
                        String userChoice = cmbIsPublished.getSelectionModel().getSelectedItem();
                        boolean isPublished = Boolean.valueOf(userChoice);
                    }

                    // Param 4
                    /**
                     * Validate the input for the entered item, ReleaseDate must be entered
                     * @param dateReleaseDate
                     */
                    if (dateReleaseDate.getValue() == null)
                    {
                        lblWarningTxt.setText("You need to pick a Release Date");
                        return;
                    } else
                    {
                        LocalDate localReleaseDate = dateReleaseDate.getValue();
                    }

                    // Param 5
                    /**
                     * Validate the input for the entered item, GameType must be entered
                     * @param cmbGameType
                     */
                    if (cmbGameType.getSelectionModel().isEmpty())
                    {
                        lblWarningTxt.setText("You need to pick a Game Type");
                        return;
                    } else
                    {
                        String theGameType = cmbGameType.getValue();
                    }
                    // Param 6
                    /**
                     * Validate the input for the entered item, txtGamePrice must be entered
                     * @param txtGamePrice
                     */
                    if (txtGamePrice.getText().isEmpty())
                    {
                        try {
                            double d = Double.parseDouble(txtGamePrice.getText());
                        } catch (NumberFormatException e)
                        {
                            lblWarningTxt.setText("You need to enter a price as a decimal value!");
                            return;
                        }
                     } else
                    {
                        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
                        double thePrice = Double.parseDouble(txtGamePrice.getText());
                    }
                    // End Validation Section -----------------------------------------------------------------------------
                    /**
                     * Set the variables now that validation has passed.
                     * @param theGameName, thePublishYear, userChoice, isPublished, localReleaseDate, theGameType, thePrice
                     */
                      String theGameName = txtgameName.getText();
                    String thePublishYear = cmbPublishYear.getValue();
                    String userChoice = cmbIsPublished.getSelectionModel().getSelectedItem();
                    boolean isPublished = Boolean.valueOf(userChoice);
                    LocalDate localReleaseDate = dateReleaseDate.getValue();
                    String theGameType = cmbGameType.getValue();
                    double thePrice = Double.parseDouble(txtGamePrice.getText());

                    // Create the Game Object
                    gameModel gameModel1 = new gameModel(theGameName,thePublishYear,isPublished, localReleaseDate ,theGameType,thePrice);

                    // Create the Ad Description
                    String TempText =  "There is a game called " + gameModel1.getGameName();
                    if (gameModel1.isPublished())
                    {
                        TempText += " is was published in " + gameModel1.getPublishYear() + " and the release date was " + gameModel1.getReleaseDate();
                    } else
                    {
                        TempText += " it is expected to be published in " + gameModel1.getPublishYear() + " with a release date of " + gameModel1.getReleaseDate();
                    }

                    TempText += " and it is a " + gameModel1.getGameType() + " Type of Game. ";
                    TempText += " The Game is priced at " + gameModel1.getGamePrice() + ".";

                    // Set the Text Area Text to the combined string
                    txtDescription.setText(TempText);
                }
    }