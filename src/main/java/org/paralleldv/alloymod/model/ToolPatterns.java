package org.paralleldv.alloymod.model;

public abstract class ToolPatterns {
    private ToolPatterns() { }

    /**
     * Uses pattern types MATERIAL and HANDLE
     * @see ToolPatternTypes
     */
    public static final String[] SWORD = {
            " m ",
            " m ",
            " h "

    };

    /**
     * Uses pattern types MATERIAL and HANDLE
     * @see ToolPatternTypes
     */
    public static final String[] AXE = {
            "mm ",
            "mh ",
            " h "
    };

    /**
     * Uses pattern types MATERIAL and HANDLE
     * @see ToolPatternTypes
     */
    public static final String[] PICKAXE = {
            "mmm",
            " h ",
            " h "
    };

    /**
     * Uses pattern types MATERIAL and HANDLE
     * @see ToolPatternTypes
     */
    public static final String[] SHOVEL = {
            " m ",
            " h ",
            " h "
    };

    /**
     * Uses pattern types MATERIAL and HANDLE
     * @see ToolPatternTypes
     */
    public static final String[] HOE = {
            "mm ",
            " h ",
            " h "
    };
}
