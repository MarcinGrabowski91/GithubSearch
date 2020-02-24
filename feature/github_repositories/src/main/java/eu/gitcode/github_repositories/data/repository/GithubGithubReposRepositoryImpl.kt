package eu.gitcode.github_repositories.data.repository

import eu.gitcode.github_repositories.data.service.GithubReposService
import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.model.Owner
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class GithubGithubReposRepositoryImpl(private val githubReposService: GithubReposService) :
    GithubReposRepository {

    override fun getRepos(keyword: String): Single<List<GithubRepo>> {
        return Single.just(
            listOf(
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdasdsa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ), GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdasdsa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asda876868sdsa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asda675747sdsa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdaewrwrewsdsa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdas111dsa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdasd1331231321321231sa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ), GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdasd132321321231312sa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdasds123231231a",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                ),
                GithubRepo(
                    createdAt = "",
                    gitUrl = "",
                    id = 0,
                    name = "asdasd12313312sa",
                    ownerData = Owner(id = 0, login = "asdasdads"),
                    stars = 0,
                    url = ""
                )
            ).asSequence().toMutableList().shuffled()
        ).delay(2000, TimeUnit.MILLISECONDS)
//        return githubReposService.getBestRepos(keyword)
//            .map { repos -> repos.toGithubRepoDomainList() }
    }

    override fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo> {
        return Single.just(
            GithubRepo(
                createdAt = "",
                gitUrl = "",
                id = 0,
                name = "ttttt",
                ownerData = Owner(id = 0, login = "ttttt"),
                stars = 0,
                url = ""
            )
        )
//        return githubReposService.getRepoInfo(ownerName, repoName)
//            .map { repo -> repo.toDomainModel() }
    }
}