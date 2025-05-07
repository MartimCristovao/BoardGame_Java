package pt.ulusofona.lp2.deisiJungle;
import org.junit.Test;
import java.io.File;
import java.util.*;
import static org.junit.Assert.*;
public class TestCreateInitialJungle {
    private GameManager gameManager = new GameManager();
    String[][] info = new String[3][3];
    String[][] playersInfo = new String[2][3];
    String[][] foodsInfo = new String[1][2];

    @Test
    public void GET_PLAYER_INFO1(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        List<String> list = new ArrayList<>();
        list.add("PLAYER_INFO");
        list.add("Ruben");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("1 | Ruben | Elefante | 180 | 1",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_PLAYER_INFO2(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        List<String> list = new ArrayList<>();
        list.add("PLAYER_INFO");
        list.add("Pedro");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("Inexistent player",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_PLAYERS_BY_SPECIE1(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "E";
        List<String> list = new ArrayList<>();
        list.add("PLAYERS_BY_SPECIE");
        list.add("E");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("Ruben,Miguel",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_PLAYERS_BY_SPECIE2(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "E";
        List<String> list = new ArrayList<>();
        list.add("PLAYERS_BY_SPECIE");
        list.add("L");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_PLAYERS_BY_SPECIE3(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "E";
        List<String> list = new ArrayList<>();
        list.add("PLAYERS_BY_SPECIE");
        list.add("M");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_MOST_TRAVELED(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "L";
        List<String> list = new ArrayList<>();
        list.add("MOST_TRAVELED");
        list.add("M");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        gameManager.moveCurrentPlayer(4, true);
        gameManager.moveCurrentPlayer(2, true);
        assertEquals("Miguel:E:4\nRuben:L:2\nTotal:6",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_TOP_ENERGETIC_OMNIVORES1(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "9";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Pato Donald";
        playersInfo[0][2] = "P";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "P";
        List<String> list = new ArrayList<>();
        list.add("TOP_ENERGETIC_OMNIVORES");
        list.add("2");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        gameManager.moveCurrentPlayer(4, true);
        gameManager.moveCurrentPlayer(2, true);
        assertEquals("Ruben:62\nPato Donald:54",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_TOP_ENERGETIC_OMNIVORES2(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "9";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Speedy Gonazalez";
        playersInfo[0][2] = "P";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Pato Donald";
        playersInfo[1][2] = "P";
        List<String> list = new ArrayList<>();
        list.add("TOP_ENERGETIC_OMNIVORES");
        list.add("1");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        gameManager.moveCurrentPlayer(2, true);
        gameManager.moveCurrentPlayer(4, true);
        assertEquals("Speedy Gonazalez:62",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void GET_CONSUMED_FOODS(){
        String[][] foodsInfo1 = new String[1][2];
        foodsInfo1[0][0] = "e";
        foodsInfo1[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "P";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "P";
        List<String> list = new ArrayList<>();
        list.add("CONSUMED_FOODS");
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertNull(null);
        }
        gameManager.moveCurrentPlayer(1, true);
        gameManager.moveCurrentPlayer(2, true);
        gameManager.moveCurrentPlayer(2, true);
        gameManager.moveCurrentPlayer(2, true);
        gameManager.moveCurrentPlayer(2, true);
        assertEquals("Erva",
                FunctionsKt.router().invoke(CommandType.GET).invoke(gameManager, list));
    }
    @Test
    public void POST_MOVE1(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "P";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "P";

        List<String> list = new ArrayList<>();
        list.add("MOVE");
        list.add("1");

        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("Apanhou comida", FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, list));
    }
    @Test
    public void POST_MOVE3(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "P";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "P";

        List<String> list = new ArrayList<>();
        list.add("MOVE");
        list.add("15");

        try{
            gameManager.createInitialJungle(30, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        gameManager.moveCurrentPlayer(10,true);
        gameManager.moveCurrentPlayer(1,true);
        assertEquals("Sem energia", FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, list));
    }
    @Test
    public void POST_MOVE4(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Miguel";
        playersInfo[0][2] = "P";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Ruben";
        playersInfo[1][2] = "P";

        List<String> list = new ArrayList<>();
        list.add("MOVE");
        list.add("-1");

        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
        assertEquals("Movimento invalido",
                FunctionsKt.router().invoke(CommandType.POST).invoke(gameManager, list));
    }
    @Test
    public void testCreateInitialJungle(){
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        /*foodsInfo[1][0] = "a";
        foodsInfo[1][1] = "3";
        foodsInfo[2][0] = "b";
        foodsInfo[2][1] = "4";
        foodsInfo[3][0] = "c";
        foodsInfo[3][1] = "6";
        foodsInfo[4][0] = "m";
        foodsInfo[4][1] = "8";*/
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertNull(null);
        }
    }
    @Test
    public void testCreateInitialJungle2() {
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        /*foodsInfo[1][0] = "a";
        foodsInfo[1][1] = "3";
        foodsInfo[2][0] = "b";
        foodsInfo[2][1] = "4";
        foodsInfo[3][0] = "c";
        foodsInfo[3][1] = "5";
        foodsInfo[4][0] = "m";
        foodsInfo[4][1] = "6";*/
        playersInfo[0][0] = "a";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
       /* playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle3InvalidFood() {
        String[][] foodsInfo1 = new String[2][2];
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Food", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle4InvalidFood() {
        String[][] foodsInfo1 = new String[2][2];
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Food", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle5InvalidFoodId() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo[0][0] = "h";
        foodsInfo[0][1] = "2";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Food", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle6InvalidName() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle7InvalidIdEspecie() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "K";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle8SameIdEspecie() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "Z";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
    }
    @Test
    public void testCreateInitialJungle9NotEnoughPayers() {
        String[][] foodsInfo1 = new String[2][2];
        String[][] playersInfo1 = new String[1][3];
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "2";
        playersInfo1[0][0] = "1";
        playersInfo1[0][1] = "Ruben";
        playersInfo1[0][2] = "Z";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
            fail("Deveria ter lancado uma exception");
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
    }
    @Test
    public void testMoveCurrentPlayer() {
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, false);
        gameManager.moveCurrentPlayer(5, false);
        gameManager.moveCurrentPlayer(0, false);
        gameManager.moveCurrentPlayer(4, false);
        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(3, false));
    }
    @Test
    public void testMoveCurrentPlayer2() {
        foodsInfo[0][0] = "c";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(1, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(1, true);
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(1, true);
        assertEquals("Valor errado", new MovementResult(MovementResultCode.CAUGHT_FOOD,"Apanhou Carne"),
                gameManager.moveCurrentPlayer(-3, false));
    }
    @Test
    public void testMoveCurrentPlayer3() {
        foodsInfo[0][0] = "c";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(3, true));
    }
    @Test
    public void testMoveCurrentPlayer4() {
        foodsInfo[0][0] = "c";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(3, true);
        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(0, true));
    }
    @Test
    public void testMoveCurrentPlayer5() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "b";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "b";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(1, true);
        assertEquals("Valor errado",new MovementResult(MovementResultCode.CAUGHT_FOOD,"Apanhou Bananas")
                ,gameManager.moveCurrentPlayer(1, true));
    }
    @Test
    public void testMoveCurrentPlayer7PassaPrimeiraCasa() {
        //Test Pass First House
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "b";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "b";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado",new MovementResult(MovementResultCode.INVALID_MOVEMENT,
                        "Movimento inválido")
                ,gameManager.moveCurrentPlayer(-1, true));
    }
    @Test
    public void testMoveCurrentPlayer8PassaUltimaCasa() {
        //Test Pass Last House
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "b";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "b";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado",new MovementResult(MovementResultCode.VALID_MOVEMENT,
                        null)
                ,gameManager.moveCurrentPlayer(11, true));
    }
    @Test
    public void testMoveCurrentPlayer9Turtle() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "b";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "b";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "T";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "T";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1, true);
        gameManager.moveCurrentPlayer(1, true);
        assertEquals("Valor errado",new MovementResult(MovementResultCode.CAUGHT_FOOD,
                        "Apanhou Bananas")
                ,gameManager.moveCurrentPlayer(3, true));
    }
    @Test
    public void testMoveCurrentPlayer10Mushroom() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "m";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "m";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "L";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "Z";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado",new MovementResult(MovementResultCode.CAUGHT_FOOD,
                        "Apanhou Cogumelo Magico")
                ,gameManager.moveCurrentPlayer(4, true));
    }
    @Test
    public void testMoveCurrentPlayer11InvalidSquares() {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "m";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "m";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "L";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "Z";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado",new MovementResult(MovementResultCode.INVALID_MOVEMENT,
                        null)
                ,gameManager.moveCurrentPlayer(9, false));
    }
    @Test
    public void testMoveCurrentPlayer12() {
        String[][] foodsInfo = new String[1][2];
        String[][] playersInfo = new String[3][3];
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "U";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(0, true));
    }

    @Test
    public void testMoveCurrentPlayer13() {
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "6";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "U";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }

        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(5, false));
    }
    @Test
    public void testMoveCurrentPlayer14() {
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "6";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "L";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "U";
        try{
            gameManager.createInitialJungle(50, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        gameManager.moveCurrentPlayer(0, true);
        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(0, true));
    }
    @Test
    public void testMoveCurrentPlayer15() {
        foodsInfo[0][0] = "m";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "U";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "Z";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, false);
        gameManager.moveCurrentPlayer(5, true);
        gameManager.moveCurrentPlayer(-3, false);
        gameManager.moveCurrentPlayer(0, false);
        assertEquals("Valor errado", new MovementResult(MovementResultCode.VALID_MOVEMENT,null),
                gameManager.moveCurrentPlayer(0, true));
    }
    @Test
    public void testMoveCurrentPlayer16() {
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "L";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "Z";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(0, true);

        assertEquals("Valor errado", new MovementResult(MovementResultCode.CAUGHT_FOOD,"Apanhou Erva"),
                gameManager.moveCurrentPlayer(0, true));
    }
    @Test
    public void testMoveCurrentPlayer17() {
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "T";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "P";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(3, true);
        gameManager.moveCurrentPlayer(0, true);

        assertEquals("Valor errado", new MovementResult(MovementResultCode.CAUGHT_FOOD,"Apanhou Erva"),
                gameManager.moveCurrentPlayer(0, true));
    }
    @Test
    public void getWinnerInfo() {
        String[][] playersInfo1 = new String[3][3];
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "6";
        playersInfo1[0][0] = "1";
        playersInfo1[0][1] = "Ruben";
        playersInfo1[0][2] = "Z";
        playersInfo1[1][0] = "2";
        playersInfo1[1][1] = "Miguel";
        playersInfo1[1][2] = "U";
        playersInfo1[2][0] = "3";
        playersInfo1[2][1] = "Martim";
        playersInfo1[2][2] = "L";
        try{
            gameManager.createInitialJungle(11, playersInfo1, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }

        gameManager.moveCurrentPlayer(5, true);
        gameManager.moveCurrentPlayer(5, true);
        gameManager.moveCurrentPlayer(6, true);

        assertEquals("Valor errado", "Miguel", gameManager.getWinnerInfo()[1]);
    }
    @Test
    public void getGameResults() {
        String[][] playersInfo1 = new String[3][3];
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "6";
        playersInfo1[0][0] = "1";
        playersInfo1[0][1] = "Ruben";
        playersInfo1[0][2] = "Z";
        playersInfo1[1][0] = "2";
        playersInfo1[1][1] = "Miguel";
        playersInfo1[1][2] = "U";
        playersInfo1[2][0] = "3";
        playersInfo1[2][1] = "Martim";
        playersInfo1[2][2] = "L";
        try{
            gameManager.createInitialJungle(11, playersInfo1, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }

        gameManager.moveCurrentPlayer(5, true);
        gameManager.moveCurrentPlayer(5, true);
        gameManager.moveCurrentPlayer(6, true);

        assertEquals("Valor errado", "[#1 Miguel, Unicornio, 6, 5, 0, #2 Martim, " +
                "Leao, 7, 6, 0, #3 Ruben, Tarzan, 6, 5, 1]", gameManager.getGameResults().toString());
    }
    @Test
    public void saveGame() throws Exception {
        String[][] foodsInfo1 = new String[2][2];
        foodsInfo1[0][0] = "b";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "b";
        foodsInfo1[1][1] = "5";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1, false);
        File file = new File("test-files/somefile1.txt");
        gameManager.saveGame(file);
        gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        gameManager.loadGame(file);
        assertEquals("erro", 2, Integer.parseInt(gameManager.getCurrentPlayerInfo()[0]));
    }
    @Test
    public void saveGame2() throws Exception {
        String[][] foodsInfo1 = new String[4][2];
        foodsInfo1[0][0] = "a";
        foodsInfo1[0][1] = "4";
        foodsInfo1[1][0] = "e";
        foodsInfo1[1][1] = "5";
        foodsInfo1[2][0] = "c";
        foodsInfo1[2][1] = "2";
        foodsInfo1[3][0] = "m";
        foodsInfo1[3][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "E";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1, false);
        File file = new File("test-files/somefile1.txt");
        gameManager.saveGame(file);
        gameManager.createInitialJungle(10, playersInfo, foodsInfo1);
        gameManager.loadGame(file);
        assertEquals("erro", 2, Integer.parseInt(gameManager.getCurrentPlayerInfo()[0]));
    }
    @Test
    public void testMoveCurrentPlayer6(){
        String[] expected = new String[3];
        expected[0] = "blank.png";
        expected[1] = "Vazio";
        expected[2] = "1,2,3";
        foodsInfo[0][0] = "c";
        foodsInfo[0][1] = "13";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(15, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(-1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(-1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(-1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(12,true);
        assertEquals("Valor errado", "Carne toxica", gameManager.getSquareInfo(13)[1]);
    }
    @Test
    public void testGetWinnerInfo() {
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "4";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        /*playersInfo[2][0] = "3";
        playersInfo[2][1] = "Martim";
        playersInfo[2][2] = "P";*/
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(3, false);
        gameManager.moveCurrentPlayer(5, false);
        gameManager.moveCurrentPlayer(0, false);
        gameManager.moveCurrentPlayer(4, false);
        assertEquals("Valor errado", 2,
                Integer.parseInt(gameManager.getWinnerInfo()[0]));
    }
    @Test
    public void testGetSquareInfo(){
        String[] expected = new String[3];
        expected[0] = "blank.png";
        expected[1] = "Agua : + 15U|20% energia";
        expected[2] = "1,2,3";
        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.getSquareInfo(3);
        assertEquals("Valor errado", expected[1], gameManager.getSquareInfo(3)[1]);
    }
    @Test
    public void testGetSquareInfo2(){
        String[] expected = new String[3];
        expected[0] = "blank.png";
        expected[1] = "Vazio";
        expected[2] = "1,2,3";
        foodsInfo[0][0] = "e";
        foodsInfo[0][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.getSquareInfo(1);
        assertEquals("Valor errado", expected[1], gameManager.getSquareInfo(4)[1]);
    }
    @Test
    public void testGetSquareInfo3(){
        String[] expected = new String[3];
        expected[0] = "blank.png";
        expected[1] = "Vazio";
        expected[2] = "1,2,3";
        foodsInfo[0][0] = "c";
        foodsInfo[0][1] = "13";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(15, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Food", ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(-1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(-1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(-1,true);
        gameManager.moveCurrentPlayer(1,true);
        gameManager.moveCurrentPlayer(12,true);
        assertEquals("Valor errado", "Carne toxica", gameManager.getSquareInfo(13)[1]);
    }
    @Test
    public void testGetSquareInfo4(){
        String[] expected = new String[3];
        expected[0] = "blank.png";
        expected[1] = "Vazio";
        expected[2] = "1,2,3";
        foodsInfo[0][0] = "b";
        foodsInfo[0][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.getSquareInfo(1);
        assertEquals("Valor errado", expected[1], gameManager.getSquareInfo(4)[1]);
    }
    @Test
    public void testGetSquareInfo5(){
        String[] expected = new String[3];
        expected[0] = "blank.png";
        expected[1] = "Vazio";
        expected[2] = "1,2,3";
        foodsInfo[0][0] = "m";
        foodsInfo[0][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "Z";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        gameManager.getSquareInfo(1);
        assertEquals("Valor errado", expected[1], gameManager.getSquareInfo(4)[1]);
    }
    @Test
    public void testGetSquareInfo6(){

        foodsInfo[0][0] = "a";
        foodsInfo[0][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "U";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado", "", gameManager.getSquareInfo(2)[2]);
    }
    /*@Test
    public void testPlayerIds(){
        foodsInfo[0][0] = "m";
        foodsInfo[0][1] = "3";
        playersInfo[0][0] = "1";
        playersInfo[0][1] = "Ruben";
        playersInfo[0][2] = "U";
        playersInfo[1][0] = "2";
        playersInfo[1][1] = "Miguel";
        playersInfo[1][2] = "L";
        try{
            gameManager.createInitialJungle(10, playersInfo, foodsInfo);
        }catch (Exception ex) {
            assertEquals("Invalid Player", ex.getMessage());
        }
        assertEquals("Valor errado", 1, gameManager.getPlayerIds(1).toString());
    }*/
}
