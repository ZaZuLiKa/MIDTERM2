package Steps.Utiles;

import Data.SQL.SQLConnection;
import Data.SQL.SQLQuery;

import java.sql.*;

import static Data.Constants.CONNECTION_STRING;
import static Data.Constants.tableName;
import static Data.SQL.SQLConnection.getConnection;


public class SQLLogic {
    SQLQuery sqlQuery=new SQLQuery();
    public String[] getOffer(String Title,Double Price, Integer Discount){
        try (Connection connection=getConnection(CONNECTION_STRING)){
            String sql=sqlQuery.getOffer();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,Title);
            preparedStatement.setDouble(2,Price);
            preparedStatement.setInt(3,Discount);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            return new String[]{
                    resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)
            };
        }catch (Exception _){
        }
        return new String[]{};
    }

}
