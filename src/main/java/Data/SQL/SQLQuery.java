package Data.SQL;

public class SQLQuery {
    public String getLastRowQuery(String table,String column){
        return "SELECT * FROM " + table +
                " ORDER BY "+column+" DESC";
    }

    public String getSearchString(){
        return "SELECT * FROM [MidtermSwoop].[dbo].[Swoop] WHERE ID = ?";
    }
    public String getOffer(){
        return "SELECT * FROM [MidtermSwoop].[dbo].[Swoop] WHERE [offerName]= ? AND [price]= ? AND [discount]= ?";
    }
}
