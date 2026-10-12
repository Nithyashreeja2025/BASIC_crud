Here is the complete process from folder creation to running your Servlet Web Application, using Ubuntu Terminal, `nano`, Java 17, and Tomcat 9. Follow the steps in order and copy the commands.

# Step 1: Check your Tomcat folder

Open Terminal and run:

```
ls ~/Desktop
```

If you see a folder like `apache-tomcat-9.0.XX`, continue. The commands below automatically find it.

# Step 2: Create the project folder

Copy and run:

```
cd ~/Desktop
mkdir -p ServletWebApp/WEB-INF/classes
cd ServletWebApp
```

Your folder structure is now:

```
ServletWebApp/
├── index.html
├── FormServlet.java
└── WEB-INF/
    └── classes/
```

We'll create `web.xml` next.

# Step 3: Create the HTML form

Run:

```
nano index.html
```

Paste this code:

```

<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <h2>Student Details Form</h2>

    <form action="FormServlet" method="post">
        Name:
        <input type="text" name="name" required>
        <br><br>

        Register Number:
        <input type="text" name="regno" required>
        <br><br>

        Department:
        <input type="text" name="department" required>
        <br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>

```

Save the file: Press `Ctrl + O`, then `Enter`, then `Ctrl + X`.

# Step 4: Create the Java servlet

Run:

```
nano FormServlet.java
```

Paste:

```

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        String department = request.getParameter("department");

        out.println("<html><body>");
        out.println("<h2>Submitted Student Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Register Number: " + regno + "</p>");
        out.println("<p>Department: " + department + "</p>");
        out.println("</body></html>");
    }
}

```

Save with `Ctrl + O` → `Enter` → `Ctrl + X`.

# Step 5: Create `web.xml`

Run:

```
mkdir -p WEB-INF
nano WEB-INF/web.xml
```

Paste:

```

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         version="3.1">

    <servlet>
        <servlet-name>FormServlet</servlet-name>
        <servlet-class>FormServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>FormServlet</servlet-name>
        <url-pattern>/FormServlet</url-pattern>
    </servlet-mapping>

</web-app>

```

Save and exit nano.

# Step 6: Find Tomcat and compile the servlet

You should still be inside `~/Desktop/ServletWebApp`.

First, find your Tomcat 9 directory:

```
TOMCAT=$(find ~/Desktop -maxdepth 1 -type d -name 'apache-tomcat-9*' | head -n 1)
echo "$TOMCAT"
```

If it prints the correct Tomcat path, compile:

```
javac -cp "$TOMCAT/lib/servlet-api.jar" -d WEB-INF/classes FormServlet.java
```

Check that the compiled file exists:

```
ls WEB-INF/classes
```

Expected output:

```
FormServlet.class
```

If `echo "$TOMCAT"` prints a blank line, Tomcat is probably installed somewhere other than your Desktop. Locate its actual path before compiling.

# Step 7: Copy the project into Tomcat

Run:

```
cp -r ~/Desktop/ServletWebApp "$TOMCAT/webapps/"
```

This puts your project inside Tomcat's application folder.

# Step 8: Start Tomcat

Run:

```
"$TOMCAT/bin/startup.sh"
```

Wait for the server to start. If you see an error, check the Tomcat logs before continuing.

# Step 9: Run the application

Open Chrome or Firefox and enter:

Student Form Web Application

URL

`http://localhost:8080/ServletWebApp/`

Open in browser&#x20;

You should see the Student Details Form.

Enter these sample values:

- Name: Arun
- Register Number: 101
- Department: CSE

Click Submit.

The output will be:

## Submitted Student Details

Name: Arun

Register Number: 101

Department: CSE

# Step 10: Stop Tomcat

When you're finished, run:

```
"$TOMCAT/bin/shutdown.sh"
```

## Remember these 4 important things

- `index.html` displays the form.
- `FormServlet.java` receives and prints the details.
- `web.xml` maps the URL to the servlet.
- Tomcat runs the web application.

Note: These instructions assume Tomcat 9 is installed directly under your Desktop and uses port `8080`. If your installation is elsewhere, adjust the Tomcat path. If you run into an error, share the exact terminal message and I can help you fix it.
