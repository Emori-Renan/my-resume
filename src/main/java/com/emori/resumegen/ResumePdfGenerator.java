package com.emori.resumegen;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResumePdfGenerator {

    public static final String DEST = "Emori_Renan_Hideki_Resume_PDFBox.pdf";

    public static void main(String[] args) {
        PDDocument document = null;
        try {
            document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Use try-with-resources to ensure contentStream is closed properly
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                // Define fonts
                PDType1Font regularFont = PDType1Font.HELVETICA;
                PDType1Font boldFont = PDType1Font.HELVETICA_BOLD;

                float currentY = page.getMediaBox().getHeight() - 40; // Start Y from top
                float margin = 50; // Left and right margin
                float width = page.getMediaBox().getWidth() - 2 * margin;

                // --- Header Section ---
                // Name (Keeping 24pt, as it's a primary heading)
                contentStream.beginText();
                contentStream.setFont(boldFont, 24);
                String name = "Emori Renan Hideki";
                float nameWidth = boldFont.getStringWidth(name) / 1000 * 24;
                float nameX = (page.getMediaBox().getWidth() - nameWidth) / 2;
                contentStream.newLineAtOffset(nameX, currentY);
                contentStream.showText(name);
                contentStream.endText();
                currentY -= 30; // Space after name

                // Contact Info (Reduced to 9pt)
                contentStream.beginText();
                contentStream.setFont(regularFont, 9); // Adjusted font size
                String contactInfo = "Asakusa, Tokyo, Japan | 0903873065 | renanemori@gmail.com | https://github.com/Emori-Renan";
                float contactInfoWidth = regularFont.getStringWidth(contactInfo) / 1000 * 9; // Adjusted font size
                float contactInfoX = (page.getMediaBox().getWidth() - contactInfoWidth) / 2;
                contentStream.newLineAtOffset(contactInfoX, currentY);
                contentStream.showText(contactInfo);
                contentStream.endText();
                currentY -= 30; // Space after contact info

                // --- Summary ---
                currentY = addSection(contentStream, "Summary", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size
                currentY = addParagraph(contentStream,
                        "Highly motivated and detail-oriented aspiring software developer with a strong foundation in backend development, web technologies, and a passion for clean code, Test-Driven Development (TDD), and Object-Oriented Programming (OOP). Currently pursuing a System Analysis and Development degree, I bring hands-on experience in Java, Vue, Python, PostgreSQL, and modern development practices. Eager to leverage my skills and self-taught knowledge to contribute to the IT market in Japan.",
                        regularFont, 10, currentY, margin, width); // Adjusted paragraph font size

                // --- Education ---
                currentY = addSection(contentStream, "Education", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size
                currentY = addParagraph(contentStream, "System Analysis and Development University Course", boldFont, 10, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Unicv (Brazil)", regularFont, 10, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Expected Completion: 2025 | Enrolled: 2023", regularFont, 9, currentY, margin, width); // Adjusted font size

                // --- Experience ---
                currentY = addSection(contentStream, "Experience", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size

                // Freelance Developer
                currentY = addParagraph(contentStream, "Freelance Developer", boldFont, 10, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Remote | January 2025", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Developed an automated bot for account creation using Python, Flet, and Selenium, implementing end-to-end logic.", regularFont, 9, currentY, margin, width); // Adjusted font size

                // Programmer at Lode
                currentY = addParagraph(contentStream, "Programmer", boldFont, 10, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Lode | Brazil | September 2023 – July 2024", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Developed and maintained a website using Java and Vue, serving as a mini-version of the company's main Java Swing product.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Performed bug solving, improvements, and new feature development for the application, with a strong focus on backend enhancements.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Utilized PostgreSQL for database management and implemented features with a focus on clean code principles.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Collaborated effectively with the QA team, Support team, and Marketing team to improve the ongoing project.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Collaborated within an Agile Scrum environment, utilizing Jira for project management and Git for version control.", regularFont, 9, currentY, margin, width); // Adjusted font size

                // --- Skills ---
                currentY = addSection(contentStream, "Skills", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size
                currentY = addParagraph(contentStream, "Programming Languages: Java, Python, JavaScript (Vue, Next.js)", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Web Technologies: Vue.js, Next.js, HTML, CSS, RESTful APIs", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Databases: PostgreSQL, Supabase", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Tools & Methodologies: Git, Jira, Scrum, Selenium, Flet, Test-Driven Development (TDD), Object-Oriented Programming (OOP)", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Concepts: Clean Code, Clean Architecture, Test-Driven Development (TDD), Object-Oriented Programming (OOP)", regularFont, 9, currentY, margin, width); // Adjusted font size

                // --- Personal Projects & Interests ---
                currentY = addSection(contentStream, "Personal Projects & Interests", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size
                currentY = addListItem(contentStream, "Employee Management System with Invoice Generator: Developing a full-stack application using Next.js for the frontend and Java for the backend, including an automated invoice generation feature.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "AI Chatbot for Recommendations: Currently developing a Python-based chatbot that recommends movies and anime using a custom dataset.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "LeetCode & Codewars: Actively practice problem-solving and algorithm development in Java.", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addListItem(contentStream, "Continuous Learning: Dedicated to self-improvement through reading industry-standard books (e.g., Clean Code, Clean Architecture, TDD).", regularFont, 9, currentY, margin, width); // Adjusted font size

                // --- Languages ---
                currentY = addSection(contentStream, "Languages", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size
                currentY = addParagraph(contentStream, "English: Fluent", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Japanese: Basic", regularFont, 9, currentY, margin, width); // Adjusted font size

                // --- Additional Information ---
                currentY = addSection(contentStream, "Additional Information", boldFont, 12, regularFont, 9, currentY, margin); // Adjusted section title size
                currentY = addParagraph(contentStream, "Age: 27", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Residency: Asakusa, Tokyo, Japan", regularFont, 9, currentY, margin, width); // Adjusted font size
                currentY = addParagraph(contentStream, "Passionate about continuous learning and self-improvement, with a keen eye for detail.", regularFont, 9, currentY, margin, width); // Adjusted font size

            } // contentStream is implicitly closed here

            document.save(DEST);
            System.out.println("Resume PDF generated successfully at: " + DEST);

        } catch (IOException e) {
            System.err.println("Error generating PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    System.err.println("Error closing document: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Helper to add a section title and a line.
     * @return new Y position
     */
    public static float addSection(PDPageContentStream contentStream, String title, PDType1Font font, float fontSize, PDType1Font lineFont, float lineFontSize, float currentY, float margin) throws IOException {
        currentY -= 15; // Space before new section (reduced from 20)
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(margin, currentY);
        contentStream.showText(title);
        contentStream.endText();
        currentY -= fontSize + 3; // Space after title (reduced from 5)

        // Draw line
        contentStream.moveTo(margin, currentY);
        contentStream.lineTo(margin + 500, currentY); // Line length
        contentStream.stroke();
        currentY -= 8; // Space after line (reduced from 10)
        return currentY;
    }

    /**
     * Helper to add a paragraph with basic word wrapping.
     * @return new Y position
     */
    public static float addParagraph(PDPageContentStream contentStream, String text, PDType1Font font, float fontSize, float currentY, float margin, float width) throws IOException {
        List<String> lines = new ArrayList<>();
        int lastSpace = -1;
        String remainingText = text;
        while (remainingText.length() > 0) {
            int spaceIndex = remainingText.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0) {
                lines.add(remainingText);
                remainingText = "";
            } else {
                String subString = remainingText.substring(0, spaceIndex);
                float size = font.getStringWidth(subString) / 1000 * fontSize;
                if (size > width) {
                    if (lastSpace == -1) {
                        lastSpace = spaceIndex;
                    }
                    lines.add(remainingText.substring(0, lastSpace));
                    remainingText = remainingText.substring(lastSpace).trim();
                    lastSpace = -1;
                } else {
                    lastSpace = spaceIndex;
                }
            }
        }

        for (String line : lines) {
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(margin, currentY);
            contentStream.showText(line);
            contentStream.endText();
            currentY -= fontSize + 1; // Line spacing (reduced from 2)
        }
        currentY -= 3; // Space after paragraph (reduced from 5)
        return currentY;
    }

    /**
     * Helper to add a list item with a bullet point.
     * @return new Y position
     */
    public static float addListItem(PDPageContentStream contentStream, String text, PDType1Font font, float fontSize, float currentY, float margin, float width) throws IOException {
        float bulletIndent = 15;
        float textIndent = 25;

        // Draw bullet
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(margin + bulletIndent, currentY);
        contentStream.showText("• ");
        contentStream.endText();

        // Add text, with wrapping
        List<String> lines = new ArrayList<>();
        int lastSpace = -1;
        String remainingText = text;
        while (remainingText.length() > 0) {
            int spaceIndex = remainingText.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0) {
                lines.add(remainingText);
                remainingText = "";
            } else {
                String subString = remainingText.substring(0, spaceIndex);
                float size = font.getStringWidth(subString) / 1000 * fontSize;
                if (size > (width - textIndent)) {
                    if (lastSpace == -1) {
                        lastSpace = spaceIndex;
                    }
                    lines.add(remainingText.substring(0, lastSpace));
                    remainingText = remainingText.substring(lastSpace).trim();
                    lastSpace = -1;
                } else {
                    lastSpace = spaceIndex;
                }
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(margin + textIndent, currentY);
            contentStream.showText(line);
            contentStream.endText();
            currentY -= fontSize + 1; // Line spacing (reduced from 2)
        }
        currentY -= 3; // Space after list item (reduced from 5)
        return currentY;
    }
}