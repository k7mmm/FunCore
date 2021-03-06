/*
 * Copyright (C) 2015 The Apocalypse MC.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package se.ranzdo.bukkit.methodcommand;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Flag implements ExecutableArgument {
    private final String identifier;
    private final String description;
    private List<FlagArgument> arguments = new ArrayList<FlagArgument>();

    public Flag(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    public void addArgument(FlagArgument argument) {
        arguments.add(argument);
    }

    @Override
    public Object execute(CommandSender sender, Arguments args) {
        return args.flagExists(this);
    }

    public List<FlagArgument> getArguments() {
        return arguments;
    }

    public String getDescription() {
        return description;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
