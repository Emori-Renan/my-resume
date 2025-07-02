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

    public static final String DEST = "Emori_Renan_Hideki_Resume.pdf";
    private static final float PAGE_BOTTOM_MARGIN = 40; // Adjust as needed

    public static void main(String[] args) {
        PDDocument document = null;
        try {
            document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDType1Font regularFont = PDType1Font.HELVETICA;
            PDType1Font boldFont = PDType1Font.HELVETICA_BOLD;

            float currentY = page.getMediaBox().getHeight() - 40;
            float margin = 50;
            float width = page.getMediaBox().getWidth() - 2 * margin;

            // Header
            contentStream.beginText();
            contentStream.setFont(boldFont, 24);
            String name = "Emori Renan Hideki";
            float nameWidth = boldFont.getStringWidth(name) / 1000 * 24;
            float nameX = (page.getMediaBox().getWidth() - nameWidth) / 2;
            contentStream.newLineAtOffset(nameX, currentY);
            contentStream.showText(name);
            contentStream.endText();
            currentY -= 30;

            // Contact Info
            contentStream.beginText();
            contentStream.setFont(regularFont, 9);
            String contactInfo = "Asakusa, Tokyo, Japan | 09038730665 | renanemori@gmail.com | https://github.com/Emori-Renan";
            float contactInfoWidth = regularFont.getStringWidth(contactInfo) / 1000 * 9;
            float contactInfoX = (page.getMediaBox().getWidth() - contactInfoWidth) / 2;
            contentStream.newLineAtOffset(contactInfoX, currentY);
            contentStream.showText(contactInfo);
            contentStream.endText();
            currentY -= 30;

            // --- Summary ---
            Object[] result = addSection(document, contentStream, "Summary", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream,
             "Junior Fullstack Developer with hands-on experience building robust web applications using Java, Spring Boot, and Vue.js. Passionate about clean code, test-driven development, and Agile methodologies. Currently pursuing a degree in System Analysis and Development. Known for self-learning, problem-solving, and delivering backend-focused features with frontend integration." 
             , regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // --- Education ---
            result = addSection(document, contentStream, "Education", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "System Analysis and Development University Course", boldFont, 10, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Unicv (Brazil)", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Expected Completion: 2025 | Enrolled: 2023", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // --- Experience ---
            result = addSection(document, contentStream, "Experience", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // Programmer at Lode
            result = addParagraph(document, contentStream, "Fullstack Software Engineer", boldFont, 10, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Lode | Brazil | September 2023 – July 2024", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Recreated the company’s desktop product as a responsive web application using Java and Vue.js, reducing support requests by 30%.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, " Refactored backend services and implemented new features following Clean Code and TDD principles.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Diagnosed and resolved bugs in production and staging environments, often coordinating closely with QA.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Conducted code reviews, ensured adherence to development standards, and managed merge requests to prepare for version releases.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Designed and optimized PostgreSQL queries for user management features, following Clean Code principles for long-term scalability.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Worked cross-functionally with the Support, Design and Marketing teams and delivered in an Agile/Scrum workflow using Jira, Git, and Figma.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];
            
            // Freelance Developer
            result = addParagraph(document, contentStream, "Freelance Developer", boldFont, 10, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Remote | January 2025", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Collaborated with two other developers to build a desktop automation tool using Python, Flet, Selenium and supabase postgresql database, packaged as an executable application.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, " Engineered an advanced account creation bot designed to simulate real-user behavior, opening multiple browser tabs to handle VPN routing, CAPTCHA solving, and security bypass techniques.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];
            
            result = addListItem(document, contentStream, "Implemented robust logic for automating user flows resembling end-to-end tests, ensuring reliability and scalability under diverse network conditions.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];
            
            // --- Skills ---
            result = addSection(document, contentStream, "Skills", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Backend: Java (Spring Boot), Python (Selenium, Flet)", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Frontend: Vue 3 (Composition API), Javascript, Typescript, Next.js, React, HTML, CSS", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Dev Tools: Git, Docker, Jira, Figma", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Testing: TDD, JUnit, Jest, Selenium", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Database: PostgreSQL, Supabase", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Practices: Clean Code, Agile/Scrum, OOP", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // --- Personal Projects & Interests ---
            result = addSection(document, contentStream, "Personal Projects & Interests", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Employee Management System – Fullstack app (Next.js (Typescript) + Java Spring Boot) with dynamic invoice generation and Dockerized deployment.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "AI Chatbot – Python-based recommendation system using custom dataset of anime and movies.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "LeetCode & Codewars: Actively practice problem-solving and algorithm development in Java.", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addListItem(document, contentStream, "Continuous Learning: Dedicated to self-improvement through reading industry-standard books (e.g., Clean Code, Clean Architecture, TDD, Microservices with Spring boot).", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // --- Languages ---
            result = addSection(document, contentStream, "Languages", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "English: Fluent", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Japanese: Basic", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Portuguese: Fluent", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // --- Additional Information ---
            result = addSection(document, contentStream, "Additional Information", boldFont, 12, regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Age: 27", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            result = addParagraph(document, contentStream, "Residency: Asakusa, Tokyo, Japan", regularFont, 10.5f, currentY, margin, width);
            currentY = (float) result[0];
            contentStream = (PDPageContentStream) result[1];

            // result = addParagraph(document, contentStream, "Passionate about continuous learning and self-improvement, with a keen eye for detail.", regularFont, 10.5f, currentY, margin, width);
            // currentY = (float) result[0];
            // contentStream = (PDPageContentStream) result[1];

            contentStream.close(); // Close the last content stream

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

    // --- Helper Methods ---

    // Updated to return an Object array containing {currentY, newContentStream}
    public static Object[] addSection(PDDocument document, PDPageContentStream contentStream, String title, PDType1Font font, float fontSize, PDType1Font lineFont, float lineFontSize, float currentY, float margin, float width) throws IOException {
        float requiredSpace = fontSize + 3 + 12 + 15; // Space for title, line, and gap before next content
        if (currentY - requiredSpace < PAGE_BOTTOM_MARGIN) {
            contentStream.close();
            PDPage newPage = new PDPage(PDRectangle.A4);
            document.addPage(newPage);
            contentStream = new PDPageContentStream(document, newPage);
            currentY = newPage.getMediaBox().getHeight() - 40; // Reset Y for new page
        }

        currentY -= 15;
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(margin, currentY);
        contentStream.showText(title);
        contentStream.endText();
        currentY -= fontSize + 3;

        contentStream.moveTo(margin, currentY);
        contentStream.lineTo(margin + width, currentY);
        contentStream.stroke();
        currentY -= 12;
        return new Object[]{currentY, contentStream};
    }

    // Updated to return an Object array containing {currentY, newContentStream}
    public static Object[] addParagraph(PDDocument document, PDPageContentStream contentStream, String text, PDType1Font font, float fontSize, float currentY, float margin, float width) throws IOException {
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
            float lineHeight = fontSize + 2.5f;
            if (currentY - lineHeight < PAGE_BOTTOM_MARGIN) {
                contentStream.close();
                PDPage newPage = new PDPage(PDRectangle.A4);
                document.addPage(newPage);
                contentStream = new PDPageContentStream(document, newPage);
                currentY = newPage.getMediaBox().getHeight() - 40;
            }
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(margin, currentY);
            contentStream.showText(line);
            contentStream.endText();
            currentY -= lineHeight;
        }
        currentY -= 7;
        return new Object[]{currentY, contentStream};
    }

    // Updated to return an Object array containing {currentY, newContentStream}
    public static Object[] addListItem(PDDocument document, PDPageContentStream contentStream, String text, PDType1Font font, float fontSize, float currentY, float margin, float width) throws IOException {
        float bulletIndent = 15;
        float textIndent = 25;

        // Calculate lines for the list item to check for page break before drawing anything
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

        float requiredSpace = (fontSize + 2.5f) * lines.size() + 7; // Total height for the list item + gap
        if (currentY - requiredSpace < PAGE_BOTTOM_MARGIN) {
            contentStream.close();
            PDPage newPage = new PDPage(PDRectangle.A4);
            document.addPage(newPage);
            contentStream = new PDPageContentStream(document, newPage);
            currentY = newPage.getMediaBox().getHeight() - 40;
        }

        // Draw bullet
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.newLineAtOffset(margin + bulletIndent, currentY);
        contentStream.showText("• ");
        contentStream.endText();

        // Add text, with wrapping
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            contentStream.beginText();
            contentStream.setFont(font, fontSize);
            contentStream.newLineAtOffset(margin + textIndent, currentY);
            contentStream.showText(line);
            contentStream.endText();
            currentY -= fontSize + 2.5f;
        }
        currentY -= 7;
        return new Object[]{currentY, contentStream};
    }
}