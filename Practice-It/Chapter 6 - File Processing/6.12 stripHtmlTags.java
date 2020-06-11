/**********************************************************************************************
Write a method called stripHtmlTags that accepts a Scanner representing an input file containing
an HTML web page as its parameter, then reads that file and prints the file's text with all HTML
tags removed. A tag is any text between the characters < and > . For example, consider the following text:

                    <html>
                    <head>
                    <title>My web page</title>
                    </head>
                    <body>
                    <p>There are many pictures of my cat here,
                    as well as my <b>very cool</b> blog page,
                    which contains <font color="red">awesome
                    stuff about my trip to Vegas.</p>

                    Here's my cat now:<img src="cat.jpg">
                    </body>
                    </html>

If the file contained these lines, your program should output the following text:



                    My web page


                    There are many pictures of my cat here,
                    as well as my very cool blog page,
                    which contains awesome
                    stuff about my trip to Vegas.

                    Here's my cat now:

You may assume that the file is a well-formed HTML document and that there are no < or >
characters inside tags.
***********************************************************************************************/

public static void stripHtmlTags(Scanner input) {
    String line;
    while (input.hasNextLine()) {
        line = input.nextLine();
        int start;
        int end;
        while (line.contains("<")) {
            start = line.indexOf("<");
            end = line.indexOf(">");
            if (start == 0 && line.length() - 1 == end) {
                line = "";
            } else if (start == 0) {
                line = line.substring(end + 1);
            } else {
                line = line.substring(0, start) + line.substring(end + 1);
            }
        }
        System.out.println(line);
    }
}
