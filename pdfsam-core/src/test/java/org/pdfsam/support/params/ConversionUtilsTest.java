/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 22 giu 2016
 * Copyright 2017 by Sober Lemur S.a.s. di Vacondio Andrea (info@pdfsam.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.support.params;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.sejda.conversion.exception.ConversionException;
import org.sejda.model.pdf.page.PageRange;

/**
 * @author Andrea Vacondio
 *
 */
public class ConversionUtilsTest {

    @Test(expected = ConversionException.class)
    public void invalid1() {
        ConversionUtils.toPageRangeSet("Chuck Norris");
    }
    
    @Test(expected = ConversionException.class)
    public void invalid2() {
        ConversionUtils.toPageRangeList("Chuck Norris");
    }

    @Test(expected = ConversionException.class)
    public void invalidRange1() {
        ConversionUtils.toPageRangeSet("1-2-3");
    }
    
    @Test(expected = ConversionException.class)
    public void invalidRange2() {
        ConversionUtils.toPageRangeList("1-2-3");
    }

    @Test(expected = ConversionException.class)
    public void endLower1() {
        ConversionUtils.toPageRangeSet("10-5");
    }
    
    @Test(expected = ConversionException.class)
    public void endLower2() {
        ConversionUtils.toPageRangeList("10-5");
    }

    @Test
    public void singlePage1() {
        Set<PageRange> pageSet = ConversionUtils.toPageRangeSet("5");
        assertEquals(1, pageSet.size());
        assertEquals(5, pageSet.stream().findFirst().get().getStart());
        assertEquals(5, pageSet.stream().findFirst().get().getEnd());
    }
    
    @Test
    public void singlePage2() {
        List<PageRange> pageSet = ConversionUtils.toPageRangeList("5");
        assertEquals(1, pageSet.size());
        assertEquals(5, pageSet.stream().findFirst().get().getStart());
        assertEquals(5, pageSet.stream().findFirst().get().getEnd());
    }

    @Test
    public void rangePage1() {
        Set<PageRange> pageSet = ConversionUtils.toPageRangeSet("5-10");
        assertEquals(1, pageSet.size());
        assertEquals(5, pageSet.stream().findFirst().get().getStart());
        assertEquals(10, pageSet.stream().findFirst().get().getEnd());
    }
    
    @Test
    public void rangePage2() {
    	List<PageRange> pageSet = ConversionUtils.toPageRangeList("5-10");
        assertEquals(1, pageSet.size());
        assertEquals(5, pageSet.stream().findFirst().get().getStart());
        assertEquals(10, pageSet.stream().findFirst().get().getEnd());
    }

    @Test
    public void endPage1() {
        Set<PageRange> pageSet = ConversionUtils.toPageRangeSet("-10");
        assertEquals(1, pageSet.size());
        assertEquals(1, pageSet.stream().findFirst().get().getStart());
        assertEquals(10, pageSet.stream().findFirst().get().getEnd());
    }
    
    @Test
    public void endPage2() {
    	List<PageRange> pageSet = ConversionUtils.toPageRangeList("-10");
        assertEquals(1, pageSet.size());
        assertEquals(1, pageSet.stream().findFirst().get().getStart());
        assertEquals(10, pageSet.stream().findFirst().get().getEnd());
    }

    @Test
    public void startPage1() {
        Set<PageRange> pageSet = ConversionUtils.toPageRangeSet("10-");
        assertEquals(1, pageSet.size());
        assertEquals(10, pageSet.stream().findFirst().get().getStart());
        assertTrue(pageSet.stream().findFirst().get().isUnbounded());
    }
    
    @Test
    public void startPage2() {
    	List<PageRange> pageSet = ConversionUtils.toPageRangeList("10-");
        assertEquals(1, pageSet.size());
        assertEquals(10, pageSet.stream().findFirst().get().getStart());
        assertTrue(pageSet.stream().findFirst().get().isUnbounded());
    }

    @Test
    public void multiple1() {
        Set<PageRange> pageSet = ConversionUtils.toPageRangeSet("2-4,10-");
        assertEquals(2, pageSet.size());
        assertEquals(2, pageSet.stream().findFirst().get().getStart());
        assertEquals(4, pageSet.stream().findFirst().get().getEnd());
        assertTrue(pageSet.stream().anyMatch(PageRange::isUnbounded));
    }
    
    @Test
    public void multiple2() {
        List<PageRange> pageSet = ConversionUtils.toPageRangeList("2-4,10-");
        assertEquals(2, pageSet.size());
        assertEquals(2, pageSet.stream().findFirst().get().getStart());
        assertEquals(4, pageSet.stream().findFirst().get().getEnd());
        assertTrue(pageSet.stream().anyMatch(PageRange::isUnbounded));
    }
    
    @Test
    public void multiple3() {
        List<PageRange> pageSet = ConversionUtils.toPageRangeList("2-4,2,2-4");
        assertEquals(3, pageSet.size());
        assertEquals(2, pageSet.stream().findFirst().get().getStart());
        assertEquals(4, pageSet.stream().findFirst().get().getEnd());
    }
    
    @Test
    public void multiple4() {
        Set<PageRange> pageSet = ConversionUtils.toPageRangeSet("2-4,2-4");
        assertEquals(1, pageSet.size());
        assertEquals(2, pageSet.stream().findFirst().get().getStart());
        assertEquals(4, pageSet.stream().findFirst().get().getEnd());
    }
    
    
    
}
