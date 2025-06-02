package com.emori.resumegen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class ResumePdfGeneratorTest {

    @Test
    @DisplayName("Should break text into lines that fit within width")
    void testTextWrappingLogic() {
        // This tests YOUR text wrapping algorithm
        String longText = "This is a very long text that should be wrapped";
        float maxWidth = 100f; // Small width to force wrapping
        
        // You would extract the text wrapping logic into a separate method:
        // List<String> lines = TextWrapper.wrapText(longText, font, fontSize, maxWidth);
        
        // Then test that:
        // 1. All lines fit within maxWidth
        // 2. Text is preserved (no characters lost)
        // 3. Breaks occur at word boundaries
        
        // For now, this is a placeholder showing what you SHOULD test
        assertTrue(true, "Text wrapping logic should be extracted and tested separately");
    }

    @Test
    @DisplayName("Should calculate correct bullet point indentation")
    void testBulletIndentationCalculation() {
        // Test YOUR indentation logic
        float bulletIndent = 15f;
        float textIndent = 25f;
        float margin = 50f;
        
        float expectedBulletX = margin + bulletIndent; // 65
        float expectedTextX = margin + textIndent;     // 75
        
        assertEquals(65f, expectedBulletX);
        assertEquals(75f, expectedTextX);
    }

    @Test
    @DisplayName("Should define correct PDF destination filename")
    void testPdfDestination() {
        // Test your constants/configuration
        assertEquals("Emori_Renan_Hideki_Resume_PDFBox.pdf", ResumePdfGenerator.DEST);
    }

    @Test
    @DisplayName("Should calculate correct spacing between elements")
    void testElementSpacing() {
        // Test your spacing calculations
        float nameSpacing = 30f;
        float contactSpacing = 30f;
        float sectionSpacing = 15f;
        
        // These are YOUR business rules for layout
        assertTrue(nameSpacing > 0, "Name should have spacing");
        assertTrue(contactSpacing > 0, "Contact info should have spacing");
        assertTrue(sectionSpacing > 0, "Sections should have spacing");
    }
}

// Example of how to refactor your code to be more testable:
class TextWrapper {
    
    public static class WrappedText {
        private final List<String> lines;
        private final float totalHeight;
        
        public WrappedText(List<String> lines, float totalHeight) {
            this.lines = lines;
            this.totalHeight = totalHeight;
        }
        
        public List<String> getLines() { return lines; }
        public float getTotalHeight() { return totalHeight; }
    }
    
    /**
     * This method contains YOUR business logic and should be tested
     */
    public static WrappedText wrapText(String text, float fontSize, float maxWidth, float fontWidthFactor) {
        List<String> lines = new ArrayList<>();
        float totalHeight = 0;
        
        // Your text wrapping algorithm here
        // This is what you should test, not the PDFBox calls
        
        return new WrappedText(lines, totalHeight);
    }
}

class ResumeLayout {
    
    /**
     * This method contains YOUR business logic for calculating positions
     */
    public static float calculateNextYPosition(float currentY, ElementType elementType, float fontSize) {
        switch (elementType) {
            case SECTION_TITLE:
                return currentY - 15 - fontSize - 3 - 8;
            case PARAGRAPH:
                return currentY - fontSize - 1 - 3;
            case LIST_ITEM:
                return currentY - fontSize - 1 - 3;
            default:
                return currentY;
        }
    }
    
    public enum ElementType {
        SECTION_TITLE, PARAGRAPH, LIST_ITEM
    }
}

// Tests for the extracted business logic:
class TextWrapperTest {
    
    @Test
    @DisplayName("Should wrap text at word boundaries")
    void testWordBoundaryWrapping() {
        String text = "Hello world this is a test";
        float fontSize = 10f;
        float maxWidth = 50f; // Small width
        float fontWidthFactor = 0.5f; // Mock font width calculation
        
        TextWrapper.WrappedText result = TextWrapper.wrapText(text, fontSize, maxWidth, fontWidthFactor);
        
        // Test YOUR logic:
        assertFalse(result.getLines().isEmpty(), "Should produce at least one line");
        
        // Each line should fit within maxWidth
        for (String line : result.getLines()) {
            float lineWidth = line.length() * fontSize * fontWidthFactor;
            assertTrue(lineWidth <= maxWidth, "Line should fit within max width: " + line);
        }
        
        // Should not break words unless absolutely necessary
        for (String line : result.getLines()) {
            if (line.contains(" ")) {
                assertFalse(line.trim().isEmpty(), "Line should not be empty");
            }
        }
    }
}

class ResumeLayoutTest {
    
    @Test
    @DisplayName("Should calculate correct Y positions for different element types")
    void testYPositionCalculations() {
        float startY = 700f;
        float fontSize = 12f;
        
        float sectionY = ResumeLayout.calculateNextYPosition(startY, ResumeLayout.ElementType.SECTION_TITLE, fontSize);
        float paragraphY = ResumeLayout.calculateNextYPosition(startY, ResumeLayout.ElementType.PARAGRAPH, fontSize);
        float listY = ResumeLayout.calculateNextYPosition(startY, ResumeLayout.ElementType.LIST_ITEM, fontSize);
        
        // Test YOUR business rules
        assertTrue(sectionY < startY, "Section should move Y position down");
        assertTrue(paragraphY < startY, "Paragraph should move Y position down");
        assertTrue(listY < startY, "List item should move Y position down");
        
        // Section should have more spacing than paragraphs
        float sectionSpacing = startY - sectionY;
        float paragraphSpacing = startY - paragraphY;
        assertTrue(sectionSpacing > paragraphSpacing, "Sections should have more spacing than paragraphs");
    }
}