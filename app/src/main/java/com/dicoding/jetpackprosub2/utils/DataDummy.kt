package com.dicoding.jetpackprosub2.utils

import com.dicoding.jetpackprosub2.data.source.local.entity.DetailEntity
import com.dicoding.jetpackprosub2.data.source.local.entity.MoviesEntity
import com.dicoding.jetpackprosub2.data.source.local.entity.TvEntity
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.*
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.Genre
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.ProductionCompany
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.ProductionCountry
import com.dicoding.jetpackprosub2.data.source.remote.response.movie.SpokenLanguage
import com.dicoding.jetpackprosub2.data.source.remote.response.tv.*

typealias TvShowGenre = com.dicoding.jetpackprosub2.data.source.remote.response.tv.Genre
typealias TvShowProductionCompany = com.dicoding.jetpackprosub2.data.source.remote.response.tv.ProductionCompany
typealias TvShowProductionCountry = com.dicoding.jetpackprosub2.data.source.remote.response.tv.ProductionCountry
typealias TvShowSpokenLanguage = com.dicoding.jetpackprosub2.data.source.remote.response.tv.SpokenLanguage

object DataDummy {
    fun getMovies(): List<MoviesEntity> {
        return listOf(
            MoviesEntity(
                337404,
                "Cruella",
                "/A0knvX7rlwTyZSKj8H5NiARb45.jpg",
                8.8
            ),
            MoviesEntity(
                632357,
                "The Unholy",
                "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                7.1
            ),
            MoviesEntity(
                503736,
                "Army of the Dead",
                "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                6.6
            )
        )
    }

    fun getDetailMovie(): DetailEntity {
        return DetailEntity(
            "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
            listOf("Comedy", "Crime"),
            337404,
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            "/A0knvX7rlwTyZSKj8H5NiARb45.jpg",
            "2021-05-26",
            134,
            "Cruella",
            8.8
        )
    }

    fun getTvShows(): List<TvEntity> {
        return listOf(
            TvEntity(
                63174,
                "Lucifer",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                8.5
            ),
            TvEntity(
                60735,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7.7
            ),
            TvEntity(
                71712,
                "The Good Doctor",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                8.6
            )
        )
    }

    fun getDetailTvShow(): DetailEntity {
        return DetailEntity(
            "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
            listOf("Crime", "Sci-Fi", "Fantasy"),
            63174,
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            "2016-01-25",
            45,
            "Lucifer",
            8.5
        )
    }

    // for remote
    fun getRemoteMovies(): List<Movie> {
        return listOf(
            Movie(
                adult = false,
                backdropPath = "/auFsy7xWxLHGC3WrVyPEeKNVVUJ.jpg",
                genreIds =  listOf(35, 80),
                id = 464052,
                originalLanguage = "en",
                originalTitle = "Cruella",
                overview = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                popularity = 4362.743,
                posterPath = "/A0knvX7rlwTyZSKj8H5NiARb45.jpg",
                releaseDate = "2021-05-26",
                title = "Cruella",
                video = false,
                voteAverage = 8.8,
                voteCount = 1270
            ),
            Movie(
                adult = false,
                backdropPath = "/wwFBRyekDcKXJwP0mImRJjAnudL.jpg",
                genreIds =  listOf(27),
                id = 632357,
                originalLanguage = "en",
                originalTitle = "The Unholy",
                overview = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                popularity = 3816.574,
                posterPath = "/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg",
                releaseDate = "2021-03-31",
                title = "The Unholy",
                video = false,
                voteAverage = 7.1,
                voteCount = 716
            ),
            Movie(
                adult = false,
                backdropPath = "/9WlJFhOSCPnaaSmsrv0B4zA8iUb.jpg",
                genreIds =  listOf(28, 27, 53),
                id = 503735,
                originalLanguage = "en",
                originalTitle = "Army of the Dead",
                overview = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                popularity = 3080.336,
                posterPath = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                releaseDate = "2021-05-14",
                title = "Army of the Dead",
                video = false,
                voteAverage = 6.6,
                voteCount = 1214
            )
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            adult = false,
            backdropPath = "/auFsy7xWxLHGC3WrVyPEeKNVVUJ.jpg",
            belongsToCollection = BelongsToCollection(
                id = 337404,
                name = "Cruella Collection",
                posterPath = "/A0knvX7rlwTyZSKj8H5NiARb45.jpg",
                backdropPath = "/auFsy7xWxLHGC3WrVyPEeKNVVUJ.jpg"
            ),
            budget = 200000000,
            genres = listOf(
                Genre(
                    id = 35,
                    name = "Comedy"
                ),
                Genre(
                    id = 80,
                    name = "Crime"
                )
            ),
            homepage = "https://movies.disney.com/cruella",
            id = 337404,
            imdbId = "tt3228774",
            originalLanguage = "en",
            originalTitle = "Cruella",
            overview = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            popularity = 4362.743,
            posterPath = "/A0knvX7rlwTyZSKj8H5NiARb45.jpg",
            productionCompanies = listOf(
                ProductionCompany(
                    id = 2,
                    logoPath = "/wdrCwmRnLFJhEoH8GSfymY85KHT.png",
                    name = "Walt Disney Pictures",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountry(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            releaseDate = "2021-05-26",
            revenue = 42600000,
            runtime = 134,
            spokenLanguages = listOf(
                SpokenLanguage(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Released",
            tagline = "Hello Cruel World",
            title = "Cruella",
            video = false,
            voteAverage = 8.8,
            voteCount = 1343

        )
    }

    fun getRemoteTvShows(): List<TvShow> {
        return listOf(
            TvShow(
                backdropPath = "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
                firstAirDate = "2016-01-25",
                genreIds = listOf(80, 10765),
                id = 63174,
                name = "Lucifer",
                originCountry = listOf("US"),
                originalLanguage = "en",
                originalName = "Lucifer",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                popularity = 1984.268,
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                voteAverage = 8.5,
                voteCount = 8962
            ),
            TvShow(
                backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                firstAirDate = "2014-10-07",
                genreIds = listOf(18, 10764),
                id = 60735,
                name = "The Flash",
                originCountry = listOf("US"),
                originalLanguage = "en",
                originalName = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                popularity = 1005.8,
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                voteAverage = 7.7,
                voteCount = 7727
            ),
            TvShow(
                backdropPath = "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                firstAirDate = "2017-09-25",
                genreIds = listOf(18),
                id = 71712,
                name = "The Good Doctor",
                originCountry = listOf("US"),
                originalLanguage = "en",
                originalName = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                popularity = 1001.957,
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                voteAverage = 8.6,
                voteCount = 8529
            )
        )
    }

    fun getRemoteDetailTvShow(): TvShowDetailResponse {
        return TvShowDetailResponse(
            backdropPath = "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
            createdBy = listOf(
                CreatedBy(
                    id = 1222585,
                    creditId = "55fdc50ec3a368132a001852",
                    name = "Tom Kapinos",
                    gender = 2,
                    profilePath = "/ol7GfeO0OIDCWGYzlg1LDLmwluO.jpg"
                )
            ),
            episodeRunTime = listOf(45),
            firstAirDate = "2016-01-25",
            genres = listOf(
                TvShowGenre(
                    id = 80,
                    name = "Crime"
                ),
                TvShowGenre(
                    id = 10765,
                    name = "Sci-Fi & Fantasy"
                )
            ),
            homepage = "https://www.netflix.com/title/80057918",
            id = 63174,
            inProduction = true,
            languages = listOf("en"),
            lastAirDate = "2021-05-28",
            lastEpisodeToAir = LastEpisodeToAir(
                airDate = "2021-05-28",
                episodeNumber = 16,
                id = 2856945,
                name = "A Chance at a Happy Ending",
                overview = "The end is nigh! Lucifer, Chloe, Maze and Amenadiel prepare for battle with Michael and his not-so-angelic army of supporters.",
                productionCode = "",
                seasonNumber = 5,
                stillPath = "/cYY0U8DAkCRAWO6rnIcZ2gW17Fz.jpg",
                voteAverage = 10.0,
                voteCount = 1
            ),
            name = "Lucifer",
            nextEpisodeToAir = null,
            networks = listOf(
                Network(
                    name = "FOX",
                    id = 19,
                    logoPath = "/1DSpHrWyOORkL9N2QHX7Adt31mQ.png",
                    originCountry = "US"
                ),
                Network(
                    name = "Netflix",
                    id = 213,
                    logoPath = "/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                    originCountry = ""
                )
            ),
            numberOfEpisodes = 93,
            numberOfSeasons = 6,
            originCountry = listOf("US"),
            originalLanguage = "en",
            originalName = "Lucifer",
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            popularity = 1984.268,
            posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
            productionCompanies = listOf(
                TvShowProductionCompany(
                    id = 43346,
                    logoPath = null,
                    name = "Fox Productions",
                    originCountry = "US"
                ),
                TvShowProductionCompany(
                    id = 1957,
                    logoPath = "/3T19XSr6yqaLNK8uJWFImPgRax0.png",
                    name = "Warner Bros. Television",
                    originCountry = "US"
                ),
                TvShowProductionCompany(
                    id = 57542,
                    logoPath = null,
                    name = "Aggressive Mediocrity",
                    originCountry = "US"
                ),
                    TvShowProductionCompany(
                            id = 9993,
                            logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                            name = "DC Entertainment",
                            originCountry = "US"
                    ),
                    TvShowProductionCompany(
                            id = 40041,
                            logoPath = "/oP8TmVSh9DCP1yhR2yvjnKfMgbg.png",
                            name = "Jerry Bruckheimer Television",
                            originCountry = "US"
                    ),
            ),
            productionCountries = listOf(
                TvShowProductionCountry(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            seasons = listOf(
                Season(
                    airDate = "2015-07-10",
                    episodeCount = 4,
                    id = 70781,
                    name = "Specials",
                    overview = "",
                    posterPath = "/bQ5FupU7DFTbx9pSgPsEZQwyZKj.jpg",
                    seasonNumber = 0
                ),
                Season(
                    airDate = "2016-01-25",
                    episodeCount = 13,
                    id = 68415,
                    name = "Season 1",
                    overview = "Bored with being the Lord of Hell, the devil relocates to Los Angeles, where he opens a nightclub and forms a connection with a homicide detective.",
                    posterPath = "/9qvNXKYqZEsYn3g3yn5tXQe0ceB.jpg",
                    seasonNumber = 1
                ),
                Season(
                    airDate = "2016-09-19",
                    episodeCount = 18,
                    id = 78529,
                    name = "Season 2",
                    overview = "Lucifer returns for another season, but his devil-may-care attitude may soon need an adjustment: His mother is coming to town.",
                    posterPath = "/fTQzbse8HKh0z6UJbMUumdbZ8PX.jpg",
                    seasonNumber = 2
                ),
                    Season(
                            airDate = "2017-10-02",
                            episodeCount = 26,
                            id = 91441,
                            name = "Season 3",
                            overview = "As Lucifer struggles with an identity crisis, a gruff new police lieutenant shakes up the status quo with Chloe and the rest of the LAPD.",
                            posterPath = "/4mKbrTqGg1daz3pDUgqd9ZSdZRt.jpg",
                            seasonNumber = 3
                    ),
                    Season(
                            airDate = "2019-05-08",
                            episodeCount = 10,
                            id = 117593,
                            name = "Season 4",
                            overview = "As Chloe struggles to come to terms with Lucifer's disturbing revelation, a rogue priest sets out to stop a long-rumored prophecy.",
                            posterPath = "/k9sLJE5geAmOCXOCbKnhSNND60J.jpg",
                            seasonNumber = 4
                    ),
                    Season(
                            airDate = "2020-08-21",
                            episodeCount = 16,
                            id = 152759,
                            name = "Season 5",
                            overview = "Lucifer makes a tumultuous return to the land of the living in hopes of making things right with Chloe. A devil’s work is never done.",
                            posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                            seasonNumber = 5
                    ),
                    Season(
                            airDate = "2020-08-21",
                            episodeCount = 10,
                            id = 192616,
                            name = "Season 6",
                            overview = "",
                            posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                            seasonNumber = 6
                    )
            ),
            spokenLanguages = listOf(
                TvShowSpokenLanguage(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Returning Series",
            tagline = "It's good to be bad.",
            type = "Scripted",
            voteAverage = 8.5,
            voteCount = 8978
        )
    }
}