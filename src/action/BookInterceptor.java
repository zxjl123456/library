package action;

import bean.Book;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BookInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        BookAction bookAction=(BookAction) actionInvocation.getAction();
        Book book=bookAction.getBook();
        if (book.getPrice()<=10){
            bookAction.setBookMessage("价格必须大于10！");
            return Action.INPUT;
        }
        else {
            book.setBookMessage("添加书籍成功！");
            return Action.SUCCESS;
        }
    }
}
