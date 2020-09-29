import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

public class gameModel {

private String GameName;
private String PublishYear;
private boolean isPublished;
private LocalDate releaseDate;
private String gameType;
private double gamePrice;

public gameModel(String gameName, String publishYear, boolean isPublished, LocalDate releaseDate, String gameType, double gamePrice) {
    setGameName(gameName);
    setPublishYear(publishYear);
    setIsPublished(isPublished);
    setReleaseDate(releaseDate);
    setGameType(gameType);
    setGamePrice(gamePrice);
}
    public String getGameName() {
        return GameName;
    }
    /**
     * Validadte the input for the entered item, game name must be text.
     * @param gameName
     */
    public void setGameName(String gameName) {
        if(isNumeric(gameName) == true)
        {
           throw new IllegalArgumentException("Input must only be text!");
        }   else
        {
             this.GameName = gameName;
        }
    }
    public String getPublishYear() {
        return PublishYear;
    }

    /**
     * This sets the Game publish Year
     * @param publishYear
     */
    public void setPublishYear(String publishYear) {
        try
        {
            // checking valid integer using parseInt() method
            Integer.parseInt(publishYear);
            this.PublishYear = publishYear;
        }
        catch (NumberFormatException e)
        {
            System.out.println(publishYear + " is not a valid integer number");
        }
    }
    public boolean isPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean published) {
        List<Boolean> validChoice = asList(true,false);
        if (validChoice.contains(published))
        {
            this.isPublished = published;
        }else
            {
                throw new IllegalArgumentException("Valid Choices are: " + validChoice);
            }
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        if (!releaseDate.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("The release date must be after the current date!");
        }else
            {
                this.releaseDate = releaseDate;
            }
    }
    public String getGameType() {
        return gameType;
    }
    public void setGameType(String gameType) {

        List<String> validChoice = asList("2D Platformer","3D Platformer", "FPS", "MMO","Text Adventure");
        if (validChoice.contains(gameType))
        {
            this.gameType = gameType;
        }else
        {
            throw new IllegalArgumentException("Valid Choices are: " + validChoice);
        }
    }
    public double getGamePrice() {
        return gamePrice;
    }
    public void setGamePrice(double gamePrice) {

        if(gamePrice >=0 && gamePrice <=100)
        {
            this.gamePrice = gamePrice;
        } else
            {
                throw new IllegalArgumentException("Game price shoud bw a positive value between 0 and 100");
            }
    }
    public static boolean isNumeric(String str) {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public String toString()
    {
        return String.format("Name of the Game: " + GameName);
    }
}
