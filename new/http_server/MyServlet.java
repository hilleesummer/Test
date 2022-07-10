public class MyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setStatus(200);
    res.getWriter().writer("Hello!");
  }
}
