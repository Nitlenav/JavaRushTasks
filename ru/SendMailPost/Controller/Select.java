package SendMailPost.Controller;

public class Select {

    private String selectAll = "Select CODE, FIRM_NAME, TODATE, OBJECT, NAME_OBJECTS, EMAIL from DATA_FOR_SEND";
    private String selectOrganizations = "Select CODE, FIRM_NAME, EMAIL from DATA_FOR_SEND where BANC = 'ОАО Банк ВТБ' and OBJECT != 998";
    private String selectPhizic = "Select CODE, FIRM_NAME, EMAIL from DATA_FOR_SEND where BANC = 'Сбербанк' and OBJECT != 998";
    private String selectActiveObject = "Select OBJECT, NAME_OBJECTS, EMAIL from DATA_FOR_SEND where OBJECT != 998";
    private String selectAllObject = "Select OBJECT, NAME_OBJECTS, EMAIL from DATA_FOR_SEND where OBJECT != 998";
    private String selectArchive = "Select CODE, FIRM_NAME, EMAIL from DATA_FOR_SEND where OBJECT != 998";

    public String getSelectOrganizations() {
        return selectOrganizations;
    }

    public String getSelectPhizic() {
        return selectPhizic;
    }

    public String getSelectActiveObject() {
        return selectActiveObject;
    }

    public String getSelectAllObject() {
        return selectAllObject;
    }

    public String getSelectArchive() {
        return selectArchive;
    }

    public String getSelectAll() {
        return selectAll;
    }
}
