package TicTacToe.entity;

public enum ArrayPlaces {

    center,leftUp,upCenter,leftCenter,upRight,rightCenter,buttomLeft,buttomRight,buttomCenter;


    public static int[] indexesInBoard(String place)
    {
        int[] index=new int[3];
        switch(place)
        {
            case "center":
                index[0]=1;
                index[1]=1;
                index[2]=ArrayPlaces.valueOf("center").ordinal();
                break;
            case "leftCenter":
                index[0]=1;
                index[1]=0;
                index[2]=ArrayPlaces.valueOf("leftCenter").ordinal();
                break;
            case "rightCenter":
                index[0]=1;
                index[1]=2;
                index[2]=ArrayPlaces.valueOf("rightCenter").ordinal();
                break;
            case "upRight":
                index[0]=0;
                index[1]=2;
                index[2]=ArrayPlaces.valueOf("upRight").ordinal();
                break;
            case "upCenter":
                index[0]=0;
                index[1]=1;
                index[2]=ArrayPlaces.valueOf("upCenter").ordinal();
                break;
            case "leftUp":
                index[0]=0;
                index[1]=0;
                index[2]=ArrayPlaces.valueOf("leftUp").ordinal();
                break;
            case "buttomLeft":
                index[0]=2;
                index[1]=0;
                index[2]=ArrayPlaces.valueOf("buttomLeft").ordinal();
                break;
            case "buttomCenter":
                index[0]=2;
                index[1]=1;
                index[2]=ArrayPlaces.valueOf("buttomCenter").ordinal();
                break;
            case "buttomRight":
                index[0]=2;
                index[1]=2;
                index[2]=ArrayPlaces.valueOf("buttomRight").ordinal();
                break;
            default:
                break;
        }
        return index;
    }
}
