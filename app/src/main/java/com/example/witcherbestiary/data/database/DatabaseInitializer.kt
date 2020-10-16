package com.example.witcherbestiary.data.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.witcherbestiary.model.*

class DatabaseInitializer {

    private val creatures: List<Creature> = listOf(
            Creature(
                    "leshen",
                    "Leshen",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/leshen_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/3/39/Tw3_journal_leshen.png/revision/latest/scale-to-width-down/350?cb=20160511131517",
                    "Humans have long been fascinated by the wild wood — living in its vicinity was the source of tales about creatures ferocious and benign, friendly and hostile. As they started to settle deeper and deeper into the forests, respect for the unknown diminished."
            ),
            Creature(
                    "chort",
                    "Chort",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/chort_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/6/6a/Tw3_journal_chort.png/revision/latest/scale-to-width-down/350?cb=20160319151758",
                    "Legends often mistake chorts for sylvans, ascribing to them the ability to speak, stand on two legs, gobble up cabbage, play pranks and work mischief around the household."
            ),
            Creature(
                    "griffin",
                    "Griffin",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/griffin_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/1/15/Tw3_journal_griffin.png/revision/latest/scale-to-width-down/350?cb=20160313093034",
                    "The griffin looks like a combination of a ferocious cat and a giant bird. It usually inhabits primeval highlands and builds its nests on unreachable mountain summits."
            ),
            Creature(
                    "white_lady",
                    "White Lady",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/white_lady_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/c/cd/Tw3_journal_thewhitelady.png/revision/latest/scale-to-width-down/350?cb=20200617024538",
                    "The apparition haunting the fields outside Novigrad turned out to be a noonwraith. Some powerful emotion must have bound it to that place - love, hate, anger or perhaps all three at once."
            ),
            Creature(
                    "cockatrice",
                    "Cockatrice",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/cockatrice_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/2/2a/Tw3_journal_cockatrice.png/revision/latest/scale-to-width-down/350?cb=20160408171230",
                    "Foolish superstitions claim cockatrices, like basilisks, can kill with their gaze alone. That is utter nonsense, however, a cockatrice's gaze being no more dangerous than that of an angry goose."
            ),
            Creature(
                    "fiend",
                    "Fiend",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/fiend_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/0/05/Tw3_journal_fiend.png/revision/latest/scale-to-width-down/350?cb=20160512145354",
                    "Fiends are walking mountains of muscle capped with horned, tooth-filled heads. Like their rarer cousins, bumbakvetches, they live in thick forests, swamps and bogs."
            ),
            Creature(
                    "drowner",
                    "Drowner",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/drowner_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/0/09/Tw3_journal_drowner.png/revision/latest/scale-to-width-down/350?cb=20160408145419",
                    "A drowner resembles a corpse dredged from the bottom of a pond. It is sickly blue or green in color, with slime and sludge oozing out of every pore and the acrid stench of rot wafting off of it."
            ),
            Creature(
                    "wraith",
                    "Wraith",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/wraith_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/c/c6/Tw3_journal_wraith.png/revision/latest/scale-to-width-down/350?cb=20160514164125",
                    "Clerics and scholars are forever debating whether spirits do in fact journey to another world after death, one where eternal joy or suffering awaits. Both groups agree, however, on what happens to spirits who, for one reason or another, remain in our world after their body breathes its last: they transform into wraiths."
            ),
            Creature(
                    "mourntart",
                    "Mourntart",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/mourntart_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/1/1e/Tw3_journal_mourntart.png/revision/latest/scale-to-width-down/350?cb=20160507151328",
                    "Most grave hags rarely attack humans, preferring instead to feed on the rotten remains they dig out of graves. Yet some individuals grow bold over the years and begin sneaking into huts to steal children and kill the elderly."
            ),
            Creature(
                    "harpy",
                    "Harpy",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/harpy_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/d/d5/Tw3_journal_harpy.png/revision/latest/scale-to-width-down/350?cb=20160415131121",
                    "It is hard to say what is most repulsive about harpies and their cousins, the shishigas: their hideous appearance, the overwhelming stench of rot and bird excrement that clings to them or their bloodcurdling screech."
            ),
            Creature(
                    "crone",
                    "Crone",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/crone_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/1/15/Tw3_journal_crones.png/revision/latest/scale-to-width-down/350?cb=20160320064504",
                    "The isolated corners of our world harbor creatures older than humans, older than academies and mages, older even than elves and dwarves. The Crones of Crookback Bog are such creatures."
            ),
            Creature(
                    "ghoul", "Ghoul",
                    "https://thewitcher3.wiki.fextralife.com/file/The-Witcher-3/ghoul_icon.jpg",
                    "https://vignette.wikia.nocookie.net/witcher/images/c/c9/Tw3_journal_ghoul.png/revision/latest/scale-to-width-down/350?cb=20160502084919",
                    "Ghouls and graveirs are hard to describe. In part, they resemble humans - yet on the whole, they are the utter negation of all that is human. Though they have arms and legs like men, they walk on all fours like dogs or badgers."
            )
    )

    private val vulnerables: List<Vulnerable> = listOf(
            Vulnerable("igni", "Igni"),
            Vulnerable("relict_oil", "Relict Oil"),
            Vulnerable("dimeritium_bomb", "Dimeritium Bomb"),
            Vulnerable("devils_puffball", "Devil`s Puffball"),
            Vulnerable("aard", "Aard"),
            Vulnerable("hybrid_oil", "Hybrid Oil"),
            Vulnerable("grapeshot", "Grapeshot"),
            Vulnerable("dimeritium", "Dimeritium"),
            Vulnerable("moon_dust", "Moon Dust"),
            Vulnerable("specter_oil", "Specter Oil"),
            Vulnerable("yrden", "Yrden"),
            Vulnerable("samum", "Samum"),
            Vulnerable("black_blood", "Black Blood"),
            Vulnerable("necrophage_oil", "Necrophage Oil"),
            Vulnerable("quen", "Quen"),
            Vulnerable("moon_dust_bombs", "Moon Dust Bombs"),
            Vulnerable("draconid_oil", "Draconid Oil")
    )

    private val locations: List<Location> = listOf(
            Location("velen", "Velen", 22f, 32f),
            Location("skellige", "Skellige", 2112f, 328f),
            Location("kaer_morhen", "Kaer Morhen", 4f, 2f),
            Location("lindenvale", "Lindenvale", 5f, 4f),
            Location("novigrad", "Novigrad", 290f, 342f),
            Location("white_orchard", "White Orchard", 422f, 472f),
            Location("oxenfurt", "Oxenfurt", 422f, 472f),
            Location("farcorners", "Farcorners", 17f, 205f),
            Location("redania", "Redania", 157f, 205f),
            Location("crookback_bog", "Crookback Bog", 157f, 205f)
    )

    private val creatureVulnerableEntries: List<CreatureVulnerableEntry> = listOf(
            CreatureVulnerableEntry(0, "leshen", "igni"),
            CreatureVulnerableEntry(0, "leshen", "relict_oil"),
            CreatureVulnerableEntry(0, "leshen", "dimeritium_bomb"),
            CreatureVulnerableEntry(0, "chort", "devils_puffball"),
            CreatureVulnerableEntry(0, "chort", "relict_oil"),
            CreatureVulnerableEntry(0, "griffin", "aard"),
            CreatureVulnerableEntry(0, "griffin", "hybrid_oil"),
            CreatureVulnerableEntry(0, "griffin", "grapeshot"),
            CreatureVulnerableEntry(0, "white_lady", "dimeritium"),
            CreatureVulnerableEntry(0, "white_lady", "moon_dust"),
            CreatureVulnerableEntry(0, "white_lady", "specter_oil"),
            CreatureVulnerableEntry(0, "white_lady", "yrden"),
            CreatureVulnerableEntry(0, "cockatrice", "grapeshot"),
            CreatureVulnerableEntry(0, "cockatrice", "draconic_oil"),
            CreatureVulnerableEntry(0, "cockatrice", "aard"),
            CreatureVulnerableEntry(0, "fiend", "samum"),
            CreatureVulnerableEntry(0, "fiend", "devils_puffball"),
            CreatureVulnerableEntry(0, "fiend", "relict_oil"),
            CreatureVulnerableEntry(0, "drowner", "necrophage_oil"),
            CreatureVulnerableEntry(0, "drowner", "igni"),
            CreatureVulnerableEntry(0, "wraith", "moon_dust_bombs"),
            CreatureVulnerableEntry(0, "wraith", "specter_oil"),
            CreatureVulnerableEntry(0, "wraith", "yrden"),
            CreatureVulnerableEntry(0, "wraith", "quen"),
            CreatureVulnerableEntry(0, "mourntart", "black_blood"),
            CreatureVulnerableEntry(0, "mourntart", "necrophage_oil"),
            CreatureVulnerableEntry(0, "mourntart", "yrden"),
            CreatureVulnerableEntry(0, "mourntart", "quen"),
            CreatureVulnerableEntry(0, "harpy", "grapeshot"),
            CreatureVulnerableEntry(0, "harpy", "hybrid_oil"),
            CreatureVulnerableEntry(0, "harpy", "aard"),
            CreatureVulnerableEntry(0, "crone", "relict_oil"),
            CreatureVulnerableEntry(0, "crone", "quen"),
            CreatureVulnerableEntry(0, "ghoul", "igni"),
            CreatureVulnerableEntry(0, "ghoul", "quen")
    )

    private val creatureLocationEntries: List<CreatureLocationEntry> = listOf(
            CreatureLocationEntry(0, "leshen", "velen"),
            CreatureLocationEntry(0, "leshen", "skellige"),
            CreatureLocationEntry(0, "chort", "velen"),
            CreatureLocationEntry(0, "chort", "skellige"),
            CreatureLocationEntry(0, "chort", "kaer_morhen"),
            CreatureLocationEntry(0, "griffin", "white_orchard"),
            CreatureLocationEntry(0, "griffin", "oxenfurt"),
            CreatureLocationEntry(0, "griffin", "velen"),
            CreatureLocationEntry(0, "griffin", "skellige"),
            CreatureLocationEntry(0, "white_lady", "farcorners"),
            CreatureLocationEntry(0, "cockatrice", "velen"),
            CreatureLocationEntry(0, "cockatrice", "redania"),
            CreatureLocationEntry(0, "fiend", "velen"),
            CreatureLocationEntry(0, "fiend", "skellige"),
            CreatureLocationEntry(0, "drowner", "novigrad"),
            CreatureLocationEntry(0, "drowner", "velen"),
            CreatureLocationEntry(0, "drowner", "skellige"),
            CreatureLocationEntry(0, "drowner", "white_orchard"),
            CreatureLocationEntry(0, "wraith", "velen"),
            CreatureLocationEntry(0, "wraith", "skellige"),
            CreatureLocationEntry(0, "wraith", "white_orchard"),
            CreatureLocationEntry(0, "mourntart", "lindenvale"),
            CreatureLocationEntry(0, "harpy", "velen"),
            CreatureLocationEntry(0, "crone", "crookback_bog"),
            CreatureLocationEntry(0, "ghoul", "velen"),
            CreatureLocationEntry(0, "ghoul", "white_orchard")
    )

    fun prepopulate(db: SupportSQLiteDatabase) {
        println("DATABASE CREATED!!!!!!!!!*************!!!!!!!!!!!!")
        prepopulateCreatures(db)
        prepopulateVulnerables(db)
        prepopulateLocations(db)
        prepopulateCreatureVulnerableEntries(db)
        prepopulateCreatureLocationEntries(db)
    }

    private fun prepopulateCreatures(db: SupportSQLiteDatabase) {
        for(item in creatures) {
            val contentValues = ContentValues()
            contentValues.put("id", item.id)
            contentValues.put("name", item.name)
            contentValues.put("preview_url", item.previewUrl)
            contentValues.put("image_url", item.imgUrl)
            contentValues.put("description", item.description)
            db.insert("creatures", SQLiteDatabase.CONFLICT_FAIL, contentValues)
        }
    }

    private fun prepopulateVulnerables(db: SupportSQLiteDatabase) {
        for(item in vulnerables) {
            val contentValues = ContentValues()
            contentValues.put("id", item.id)
            contentValues.put("name", item.name)
            db.insert("vulnerables", SQLiteDatabase.CONFLICT_FAIL, contentValues)
        }
    }

    private fun prepopulateLocations(db: SupportSQLiteDatabase) {
        for(item in locations) {
            val contentValues = ContentValues()
            contentValues.put("id", item.id)
            contentValues.put("name", item.name)
            contentValues.put("x", item.x)
            contentValues.put("y", item.y)
            db.insert("locations", SQLiteDatabase.CONFLICT_FAIL, contentValues)
        }
    }

    private fun prepopulateCreatureVulnerableEntries(db: SupportSQLiteDatabase) {
        for(item in creatureVulnerableEntries) {
            val contentValues = ContentValues()
            contentValues.put("creature_id", item.creatureId)
            contentValues.put("vulnerable_id", item.vulnerableId)
            db.insert("creature_vulnerable_entries", SQLiteDatabase.CONFLICT_FAIL, contentValues)
        }
    }

    private fun prepopulateCreatureLocationEntries(db: SupportSQLiteDatabase) {
        for(item in creatureLocationEntries) {
            val contentValues = ContentValues()
            contentValues.put("creature_id", item.creatureId)
            contentValues.put("location_id", item.locationId)
            db.insert("creature_location_entries", SQLiteDatabase.CONFLICT_FAIL, contentValues)
        }
    }
}