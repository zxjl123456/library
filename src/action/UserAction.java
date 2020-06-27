package action;

import java.util.Map;

import bean.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import dao.UserDao;
import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private User user;
    private String userMessage;
    public String getUserMessage() {
        return userMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void validate() {
        if (user != null) {
            if (user.getPassWord() == null || user.getPassWord().trim().equals("")) {
                this.addFieldError("user.password", "密码不能为空！");
            }
        }
        System.out.println("validate");
    }

    public void validateLogin() {
        if (user.getUserName() == null || user.getUserName().trim().equals("")) {
            this.addFieldError("user.userName", "用户名不能为空！");
        }
        System.out.println("validateLogin");
    }

    public String login() {
		/*if (teacher.getId() == null || teacher.getId().trim().equals("")) {
			this.addFieldError("teacher.id", "工号不能为空！");
			return INPUT;
		}*/
        ActionContext context = ActionContext.getContext();
        Map<String,Object>session=context.getSession();
        User user1 = (User) session.get("user");
        if (user1 == null) {
            user1 = new UserDao().Validate(user.getUserName(), user.getPassWord());
            if (user1 != null) {
                session.put("user", user1);
                return SUCCESS;
            } else {
                addActionError("ActionError: 你输入的工号或密码不正确！");
                addActionError("ActionError: 请重新输入。");
                addActionMessage("ActionMessage:你输入的工号或密码不正确！");
                addFieldError("user.userName", "用户名不正确");
                addFieldError("user.password", "教师密码不正确");
                userMessage = "你输入的工号或密码不正确！";
                return ERROR;
            }
        } else {
            //Session中有Teacher对象，说明教师已经正确登录系统且未注销
            System.out.println("success: user=!null");

			/*if (tea.getId().equals(teacher.getId()) && tea.getPassword().equals(teacher.getPassword())) {
				return SUCCESS;
			} else {
				return INPUT;
			}*/

            return SUCCESS;
        }
    }

    public String logout() {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        session.remove("user");
        return INPUT;
    }
}
